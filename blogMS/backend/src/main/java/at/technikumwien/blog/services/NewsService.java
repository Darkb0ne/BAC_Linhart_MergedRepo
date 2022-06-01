package at.technikumwien.blog.services;

import at.technikumwien.blog.models.News;
import at.technikumwien.blog.models.NewsAuthorAPIDto;
import at.technikumwien.blog.models.NewsDto;
import at.technikumwien.blog.models.NewsPagedList;
import javassist.NotFoundException;
import org.springframework.data.domain.PageRequest;


public interface NewsService {
    NewsPagedList listNews(String newsTitle, PageRequest pageRequest);
    NewsDto getNewsById(Long id);
    News saveNews(NewsAuthorAPIDto newsAuthorAPIDto);
    void updateIncreaseViewCount(Long id) throws NotFoundException;
    NewsDto deleteNewsById(String id);

}
