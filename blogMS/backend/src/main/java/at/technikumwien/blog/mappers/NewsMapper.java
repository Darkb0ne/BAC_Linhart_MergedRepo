package at.technikumwien.blog.mappers;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.models.AuthorDto;
import at.technikumwien.blog.models.News;
import at.technikumwien.blog.models.NewsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsDto newsToNewsDto(News news);

    News newsDtoToNews(NewsDto newsDto);

    AuthorDto authorToAuthorDto(Author author);
}
