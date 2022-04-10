package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.Turn;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${sample.rabbitmq.exchange}")
    private String exchange;

    @Value("${sample.rabbitmq.routingkey}")
    private String routingkey;
    private AtomicLong count = new AtomicLong(0L);

    @Scheduled
    public void send(Turn turn) {

        rabbitTemplate.convertAndSend(exchange, routingkey, turn);
        System.out.println("( " + count.incrementAndGet() + " ) Send =: " + turn);
    }
}

