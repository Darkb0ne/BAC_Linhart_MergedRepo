package at.technikumwien.blog.services;

import at.technikumwien.blog.models.Attraction;
import at.technikumwien.blog.repositories.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttractionService {

    @Autowired
    private AttractionRepository repository;

    public Attraction findAttractionById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Attraction findAttractionByName(String name){return repository.findAttractionByName(name);}

    public Attraction saveAttraction(Attraction attraction){
        return repository.save(attraction);
    }
}
