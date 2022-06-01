package at.technikumwien.blog.bootstrap;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.models.News;
import at.technikumwien.blog.models.NewsAuthor;
import at.technikumwien.blog.repositories.AuthorRepository;
import at.technikumwien.blog.repositories.NewsAuthorRepository;
import at.technikumwien.blog.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(4)
public class NewsAuthorLoader implements CommandLineRunner {
    private final NewsRepository newsRepository;
    private final AuthorRepository authorRepository;

    private final NewsAuthorRepository newsAuthorRepository;

    @Override
    public void run(String... args){
        loadNewsAuthorObjects();
    }

    private void loadNewsAuthorObjects(){
        if(newsRepository.count() != 0 && authorRepository.count() != 0 && newsAuthorRepository.count() == 0){
            System.out.println("Loading NewsAuthor Objects...");
            News news1 = newsRepository.getById(1L);
            News news2 = newsRepository.getById(2L);

            Author author1 = authorRepository.getById(1L);
            Author author2 = authorRepository.getById(2L);

            NewsAuthor newsAuthor1 = new NewsAuthor(news1, author1);

            NewsAuthor newsAuthor2 = new NewsAuthor(news2, author2);
            NewsAuthor newsAuthor3 = new NewsAuthor(news2, author1);
            newsAuthorRepository.save(newsAuthor1);
            newsAuthorRepository.save(newsAuthor2);
            newsAuthorRepository.save(newsAuthor3);
        }
    }
}
