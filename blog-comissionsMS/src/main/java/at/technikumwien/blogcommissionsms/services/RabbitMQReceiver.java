package at.technikumwien.blogcommissionsms.services;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMQReceiver{

    @Autowired
    RabbitMQSender rabbitMQSender;

    @RabbitListener(queues = "queue.commissions")
    public void onMessage(Message message) {
        Gson gson = new Gson();
        Map<Long, Integer> commissions = gson.fromJson(new String(message.getBody()), Map.class);
        for (Map.Entry<Long, Integer> entry : commissions.entrySet()) {
            System.out.println("AuthorId: " + entry.getKey() + " has been payed : " + entry.getValue() + "c." );
        }
        System.out.println("-----Authors have been payed out.------");

        rabbitMQSender.sendCommissionsValidation();
    }
}
