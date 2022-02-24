package com.xiaojinzi.client;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;


@Controller
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public Queue testQueue() {
        return new Queue("testQueue");
    }

    @RabbitListener(queues = "testQueue")
    public void listen(String in) {
        System.out.println("result = " + in);
    }

}