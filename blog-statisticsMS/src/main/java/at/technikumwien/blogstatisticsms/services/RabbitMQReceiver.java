package at.technikumwien.blogstatisticsms.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {
    @Autowired
    EventService eventService;

    @Bean
    public MessageListener receiveData(final AmqpTemplate rabbitTemplate) {
        return new MessageListener() {
            public void onMessage(Message message) {
                String body = new String(message.getBody());

                System.out.println("Received: " + body);
                body = body.substring(1, body.length() - 1);
                String[] parts = body.split("#");
                for (String part : parts) {
                    System.out.println("Part: " + part);
                }

                eventService.processEvent(parts);
    }};}

}
