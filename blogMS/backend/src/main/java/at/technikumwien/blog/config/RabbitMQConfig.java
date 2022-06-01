package at.technikumwien.blog.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.statistics.queue}")
    String queueName;

    @Value("${rabbitmq.statistics.routingKey}")
    private String routingKey;

    @Value("${rabbitmq.commissions.queue}")
    String commissionsQueueName;

    @Value("${rabbitmq.commissions.routingKey}")
    private String commissionsRoutingKey;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    Queue statisticsQueue() {
        return new Queue(queueName, false);
    }


    @Bean
    Queue commissionsQueue() {
        return new Queue(commissionsQueueName, false);
    }

/*
    //create MessageListenerContainer using default connection factory
    @Bean
    MessageListenerContainer statisticsMessageListenerContainer(ConnectionFactory connectionFactory ) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(statisticsQueue());
        return simpleMessageListenerContainer;
    }
    @Bean
    MessageListenerContainer commissionsMessageListenerContainer(ConnectionFactory connectionFactory ) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(commissionsQueue());
        return simpleMessageListenerContainer;
    }*/

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

/*
    @Bean
    public AmqpTemplate rabbitTemplateNew(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
 */
}