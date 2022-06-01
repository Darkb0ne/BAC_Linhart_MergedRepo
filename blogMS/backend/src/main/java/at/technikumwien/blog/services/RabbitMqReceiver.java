package at.technikumwien.blog.services;

import at.technikumwien.blog.repositories.NewsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqReceiver {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @RabbitListener(queues = "queue.commissions.acknowledge")
    public void receiveMessage(String message) {
        newsRepository.findAll().forEach(news -> {
            news.setViewCount(0);
            newsRepository.save(news);
        });
        System.out.println("#####Received message: " + message);
    }

}
