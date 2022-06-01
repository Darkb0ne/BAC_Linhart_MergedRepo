package at.technikumwien.blog.mappers;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.models.AuthorDto;
import at.technikumwien.blog.models.AuthorDto.AuthorDtoBuilder;
import at.technikumwien.blog.models.News;
import at.technikumwien.blog.models.News.NewsBuilder;
import at.technikumwien.blog.models.NewsDto;
import at.technikumwien.blog.models.NewsDto.NewsDtoBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-23T18:26:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto newsToNewsDto(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDtoBuilder newsDto = NewsDto.builder();

        newsDto.id( news.getId() );
        newsDto.title( news.getTitle() );
        newsDto.text( news.getText() );
        newsDto.viewCount( news.getViewCount() );
        newsDto.publicationDate( news.getPublicationDate() );
        newsDto.topNews( news.isTopNews() );
        newsDto.attraction( news.getAttraction() );

        return newsDto.build();
    }

    @Override
    public News newsDtoToNews(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        NewsBuilder news = News.builder();

        news.id( newsDto.getId() );
        news.title( newsDto.getTitle() );
        news.text( newsDto.getText() );
        news.publicationDate( newsDto.getPublicationDate() );
        news.viewCount( newsDto.getViewCount() );
        news.topNews( newsDto.isTopNews() );
        news.attraction( newsDto.getAttraction() );

        return news.build();
    }

    @Override
    public AuthorDto authorToAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.id( author.getId() );
        authorDto.email( author.getEmail() );

        return authorDto.build();
    }
}
