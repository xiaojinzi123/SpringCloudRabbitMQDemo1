package com.xiaojinzi.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ResponseBody
    @RequestMapping("pushMessage")
    public String pushMessage() {
        amqpTemplate.convertAndSend("testQueue", "testData");
        return "hello, convertAndSend 'testData' success ";
    }

    @Bean
    public Queue testQueue() {
        return new Queue("testQueue");
    }

}