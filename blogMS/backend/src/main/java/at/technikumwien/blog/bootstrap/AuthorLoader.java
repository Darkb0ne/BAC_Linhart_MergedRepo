package at.technikumwien.blog.bootstrap;

import at.technikumwien.blog.models.Author;
import at.technikumwien.blog.models.Sex;
import at.technikumwien.blog.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(2)
public class AuthorLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAuthorObjects();
    }

    private void loadAuthorObjects(){
        if(authorRepository.count() == 0){
            authorRepository.save(Author.builder().email("felix@yahoo.at").firstName("Felix").lastName("Linhart").sex(Sex.MALE).build());
            authorRepository.save(Author.builder().email("ayrton@gmail.at").firstName("Ayrton").lastName("Novakovic").sex(Sex.MALE).build());
            authorRepository.save(Author.builder().email("jules@gmail.com").firstName("Jules").lastName("Ajde").sex(Sex.FEMALE).build());
            authorRepository.save(Author.builder().email("adminboss@admin.at").firstName("Admin").lastName("Boss").sex(Sex.INTERSEX).build());
        }
    }
}
