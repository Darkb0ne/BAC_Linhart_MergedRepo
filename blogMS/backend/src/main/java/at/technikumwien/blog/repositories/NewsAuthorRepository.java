package at.technikumwien.blog.repositories;

import at.technikumwien.blog.models.NewsAuthor;
import at.technikumwien.blog.models.NewsAuthorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsAuthorRepository extends JpaRepository<NewsAuthor, NewsAuthorId> {
    List<NewsAuthor> findNewsAuthorByNewsId(Long newsId);
}
