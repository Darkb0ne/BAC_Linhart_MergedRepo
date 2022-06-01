package at.technikumwien.blogstatisticsms.services;

import at.technikumwien.blogstatisticsms.models.Event;
import at.technikumwien.blogstatisticsms.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     *
     * @param baseName news or attraction
     * @param timeFrame =>
     *                  1 => last month
     *                  2 => all-time
     * @return
     */
    public Map<String,Integer> calculateStatistics(String baseName, int timeFrame){
        List<Event> events = new ArrayList<>();
        Map<String, Integer> stats = new HashMap<>();
        if(timeFrame == 1){
            events = eventRepository.findAllByCreatedAtAfter(Date.from(ZonedDateTime.now().minusMonths(1).toInstant()));
        }
        else if(timeFrame == 2){
             events = eventRepository.findAll();
        }
        for(Event event : events){
            if(baseName.equals("news")){
                if(stats.containsKey(event.getNewsTitle())){
                    stats.put(event.getNewsTitle(), stats.get(event.getNewsTitle()) + 1);
                }
                else{
                    stats.put(event.getNewsTitle(), 1);
                }
            }
            else if(baseName.equals("attraction")){
                if(stats.containsKey(event.getAttractionName())){
                    stats.put(event.getAttractionName(), stats.get(event.getAttractionName()) + 1);
                }
                else{
                    stats.put(event.getAttractionName(), 1);
                }
            }

        }
        return stats;
    }

    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    public void processEvent(String[] body) {
        Event event = Event.builder()
                .newsId(Long.valueOf(body[0]))
                .newsTitle(body[1])
                .attractionId(Long.valueOf(body[2]))
                .attractionName(body[3])
                .build();

        saveEvent(event);
    }
}
