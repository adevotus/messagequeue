package com.example.Rabbitmq.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderStatus {


    private Order order;
    private String status;//status for the order can be compelete or on progress
    private String message;
}
