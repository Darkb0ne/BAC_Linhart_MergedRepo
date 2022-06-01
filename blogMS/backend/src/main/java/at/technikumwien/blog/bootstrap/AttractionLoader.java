package at.technikumwien.blog.bootstrap;

import at.technikumwien.blog.models.Attraction;
import at.technikumwien.blog.repositories.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(1)
public class AttractionLoader implements CommandLineRunner {

    private final AttractionRepository attractionRepository;

    @Override
    public void run(String... args){
        System.out.println("Loading attractions...");
        loadAttractionObjects();
    }

    private void loadAttractionObjects(){
        if(attractionRepository.count() == 0){
            attractionRepository.save(Attraction.builder().name("Naturhistorisches Museum").build());
            attractionRepository.save(Attraction.builder().name("Technisches Museum").build());
            attractionRepository.save(Attraction.builder().name("Kino").build());
            attractionRepository.save(Attraction.builder().name("Der Graben").build());
        }
    }
}
