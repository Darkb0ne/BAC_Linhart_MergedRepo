package at.technikumwien.blog.services;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.models.NewsAuthor;
import at.technikumwien.blog.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private NewsAuthorService newsAuthorService;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getAllAuthorsByNewsId(Long newsId){
        List<NewsAuthor> allNewsAuthorsByIds = newsAuthorService.findAllByNewsId(newsId);
        ArrayList<Long> authorIds = new ArrayList<>();
        for(NewsAuthor newsAuthor : allNewsAuthorsByIds){
            authorIds.add(newsAuthor.getAuthor().getId());
        }
        return authorRepository.findAllById(authorIds);
    }

    public Author saveAuthor(Author author){
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).get();
    }
}
