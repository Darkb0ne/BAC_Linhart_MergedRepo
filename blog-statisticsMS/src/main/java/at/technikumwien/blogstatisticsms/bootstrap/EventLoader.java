package at.technikumwien.blogstatisticsms.bootstrap;

import at.technikumwien.blogstatisticsms.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class EventLoader implements CommandLineRunner {
    @Autowired
    EventRepository eventRepository;

    @Override
    public void run(String... args){
        loadEventObjects();
    }

    private void loadEventObjects() {
        /*
        eventRepository.save(Event.builder()
                .attractionId(1L)
                .newsId(1L)
                .newsTitle("News 1")
                .attractionName("Naturhistorisches Museum")
                .build());
        eventRepository.save(Event.builder()
                .attractionId(2L)
                .newsId(2L)
                .newsTitle("News 2")
                .attractionName("Technisches Museum")
                .build());
    }*/
    }
}
