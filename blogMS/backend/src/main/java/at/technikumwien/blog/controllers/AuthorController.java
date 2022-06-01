package at.technikumwien.blog.controllers;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.services.AuthorService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @Timed(value = "getAuthors.time", description = "Time taken to return all authors")
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public ResponseEntity createAuthor(@RequestBody Author author) throws URISyntaxException {
        Author savedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.created(new URI("/authors/" + savedAuthor.getId())).body(savedAuthor);
    }

    @GetMapping("/news/{id}")
    public List<Author> getAuthorsByNewsId(@PathVariable Long id) {
        return authorService.getAllAuthorsByNewsId(id);
    }


    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }
}
