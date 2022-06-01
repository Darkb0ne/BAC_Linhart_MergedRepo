package at.technikumwien.blog.services;

import at.technikumwien.blog.mappers.NewsMapper;
import at.technikumwien.blog.models.*;
import at.technikumwien.blog.repositories.NewsRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.micrometer.core.instrument.util.StringUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AttractionService attractionService;

    @Autowired
    private NewsAuthorService newsAuthorService;

    @Override
    public NewsPagedList listNews(String newsTitle, PageRequest pageRequest) {
        NewsPagedList newsPagedList;
        Page<News> newsPage;
        if(!isEmpty(newsTitle)){
            newsPage = newsRepository.findAllNewsByTitle(newsTitle, pageRequest);
        }
        else{
            newsPage = newsRepository.findAll(pageRequest);
        }

        newsPagedList = new NewsPagedList(newsPage
                .getContent()
                .stream()
                .map(newsMapper::newsToNewsDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(newsPage.getPageable().getPageNumber(),
                                newsPage.getPageable().getPageSize()),
                newsPage.getTotalElements());


        return newsPagedList;
    }

    @Override
    public NewsDto getNewsById(Long id) {

        System.out.println("id: " + id);
        System.out.println(newsRepository.findById(id).isPresent());
        try {
            System.out.println("test" + newsMapper.newsToNewsDto(newsRepository.findById(id).orElseThrow(() -> new NotFoundException("News not found"))));
            return newsMapper.newsToNewsDto(newsRepository.findById(id).orElseThrow(() -> new NotFoundException("News not found")));
            //System.out.println(newsRepository.findById(id).get());
            //return(newsRepository.findById(id).get());

        }
        catch (NotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public News saveNews(NewsAuthorAPIDto newsAuthorAPIDto){
        List<Author> authors = new ArrayList<>(newsAuthorAPIDto.getAuthorIds().size());
        for(Long authorId : newsAuthorAPIDto.getAuthorIds()){
            Author cacheAuthor = authorService.getAuthorById(authorId);
            authors.add(cacheAuthor);
            System.out.println("authorid" + cacheAuthor.getId());
        }
        Attraction attraction = new Attraction();
        if(attractionService.findAttractionByName(newsAuthorAPIDto.getAttractionName()) == null){
            System.out.println("attraction not found");
            attraction = attractionService.saveAttraction(Attraction.builder()
                            .name(newsAuthorAPIDto.getAttractionName())
                     .build());
        }
        else{
            attraction = attractionService.findAttractionByName(newsAuthorAPIDto.getAttractionName());
        }
        News news = News.builder()
                .text(newsAuthorAPIDto.getNewsText())
                .title(newsAuthorAPIDto.getNewsTitle())
                .attraction(attraction)
                .publicationDate(LocalDate.now())
                .build();
        News storedNews = newsRepository.save(news);
        System.out.println("storedNews" + storedNews.getId());
        for(Author author : authors){
            newsAuthorService.saveNewsAuthor(new NewsAuthor(storedNews, author));
        }
        return news;
    }

    @Override
    public void updateIncreaseViewCount(Long id) throws NotFoundException {
        News news = newsRepository.findById(id).orElseThrow(() -> new NotFoundException("News not found"));
        news.setViewCount(news.getViewCount() + 1);
        newsRepository.save(news);

    }

    @Override
    public NewsDto deleteNewsById(String id) {
        return null;
    }
}
