package at.technikumwien.blog.bootstrap;

import at.technikumwien.blog.models.News;
import at.technikumwien.blog.repositories.AttractionRepository;
import at.technikumwien.blog.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@RequiredArgsConstructor
@Component
@Order(3)
public class NewsLoader implements CommandLineRunner {

    private final NewsRepository newsRepository;
    private final AttractionRepository attractionRepository;

    @Override
    public void run(String... args) throws Exception {
        loadNewsObjects();
    }

    private void loadNewsObjects() {
        if(newsRepository.count() == 0) {
            newsRepository.save(News.builder()
                    .title("News 1")
                    .text("Text 1")
                    .publicationDate(LocalDate.now())
                    .topNews(false)
                            .viewCount(10)
                    .attraction(attractionRepository.findById(1L).get())
                    .build());

            newsRepository.save(News.builder()
                    .title("News 2")
                            .viewCount(20)
                    .text("Text 2")
                    .publicationDate(LocalDate.now())
                    .attraction(attractionRepository.findById(3L).get())
                    .topNews(false).build());
        }
        System.out.println("News objects loaded");
    }
}
