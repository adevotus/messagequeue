package com.example.Rabbitmq.consumer;


import com.example.Rabbitmq.config.MessageConfig;
import com.example.Rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void ConsumemessageFromQueue(OrderStatus orderStatus){
        System.out.println("message Received from QUEUE" + orderStatus);

    }
}
