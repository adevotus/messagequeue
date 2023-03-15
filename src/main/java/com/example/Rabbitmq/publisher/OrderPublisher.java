package com.example.Rabbitmq.publisher;


import com.example.Rabbitmq.config.MessageConfig;
import com.example.Rabbitmq.dto.Order;
import com.example.Rabbitmq.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ordered")
@RequiredArgsConstructor
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String BookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());// my request able to goo through payment or service
        OrderStatus orderStatus = new OrderStatus(order , "PROCESS", "order placed successfully" +restaurantName);
        template.convertAndSend(MessageConfig.EXACHANGE, MessageConfig.ROUTINGKEY, orderStatus);

        return "success !!";
    }

}
