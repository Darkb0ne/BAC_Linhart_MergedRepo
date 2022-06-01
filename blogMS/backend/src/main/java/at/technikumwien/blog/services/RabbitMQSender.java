package at.technikumwien.blog.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@EnableAsync
@Service
public class RabbitMQSender {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private NewsAuthorService newsAuthorService;

    @Scheduled(fixedRate = 30000)
    //every Month, at the first day of the month, at noon
    //@Scheduled(cron = "0 0 12 1 1/1 ?")
    @Async
    public void sendScheduledMessagesToCommissionsMS() {
        Map<Long, Integer> newsAuthorMap = newsAuthorService.sumUpViewCountsOfAuthors();
        System.out.println(newsAuthorMap.size());
        rabbitTemplate.convertAndSend("queue.commissions", newsAuthorService.sumUpViewCountsOfAuthors());
        //rabbitTemplate.convertAndSend("queue.commissions", "test");
        //System.out.println( "Fixed scheduled task - " + System.currentTimeMillis() / 1000);
    }

    @Async
    public void sendMessagesToStatisticsMS(Long newsId, String newsTitle, Long attractionId, String attractionName) {
        String send = newsId + "#" + newsTitle + "#" + attractionId + "#" + attractionName;
        //rabbitTemplate.type
        rabbitTemplate.convertAndSend("queue.statistics", send);
    }
}

