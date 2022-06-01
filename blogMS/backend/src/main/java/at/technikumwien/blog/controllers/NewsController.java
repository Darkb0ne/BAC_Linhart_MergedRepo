package at.technikumwien.blog.controllers;

import at.technikumwien.blog.mappers.NewsMapper;
import at.technikumwien.blog.models.*;
import at.technikumwien.blog.services.AttractionService;
import at.technikumwien.blog.services.NewsService;
import at.technikumwien.blog.services.RabbitMQSender;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class NewsController {

    private final NewsService newsService;
    private final AttractionService attractionService;
    @Autowired
    public final NewsMapper mapper;

    @Autowired
    private final RabbitMQSender rabbitMQSender;

    @GetMapping(produces = { "application/json" }, path = "news")
    public ResponseEntity<NewsPagedList> getNews(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(value = "newsTitle", required = false) String newsTitle){
    if(pageNumber == null) pageNumber = 0;
    if(pageSize == null) pageSize = 25;

    NewsPagedList newsList = newsService.listNews(newsTitle, PageRequest.of(pageNumber, pageSize));
    return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("news/{newsId}")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<News> getNewsById(@PathVariable Long newsId) throws NotFoundException {
        newsService.updateIncreaseViewCount(newsId);
        News news = mapper.newsDtoToNews(newsService.getNewsById(newsId));
        Attraction attraction = attractionService.findAttractionById(news.getAttraction().getId());
        rabbitMQSender.sendMessagesToStatisticsMS(newsId, news.getTitle(), attraction.getId(), attraction.getName());
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @PostMapping(path="news")
    public ResponseEntity<NewsDto> saveNewNews(@RequestBody NewsAuthorAPIDto newsAuthorAPIDto) {
        NewsDto newsDto = mapper.newsToNewsDto(newsService.saveNews(newsAuthorAPIDto));
        return new ResponseEntity<NewsDto>(newsDto, HttpStatus.CREATED);
    }
}
