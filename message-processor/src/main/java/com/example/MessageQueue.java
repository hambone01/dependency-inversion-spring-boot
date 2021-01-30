package com.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class MessageQueue {
    LinkedBlockingQueue<String> messages;

    public MessageQueue() {
        this.messages = new LinkedBlockingQueue<>();;
    }

    @Bean
    public Queue<String> messageBus()
    {
        return messages;
    }
}
