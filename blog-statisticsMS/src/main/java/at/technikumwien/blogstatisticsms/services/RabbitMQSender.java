package at.technikumwien.blogstatisticsms.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    public void sendStatisticsValidation() {
        rabbitTemplate.convertAndSend("queue.statistics.acknowledge", "Statistics Validation");
    }

    @Async
    public void requestStatisticsData() {
        rabbitTemplate.convertAndSend("queue.statistics.requestData", "Data pls");
    }

}
