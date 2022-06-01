package at.technikumwien.blogcommissionsms.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;



    //TODO
    public void sendCommissionsValidation() {
        rabbitTemplate.convertAndSend("queue.commissions.acknowledge", "Authors have been payed out.");

    }
}
