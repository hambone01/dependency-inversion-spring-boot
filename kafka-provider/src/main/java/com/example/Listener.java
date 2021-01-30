package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
public class Listener {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public final Consumer<String> handler;

    /**
     * THe consumer must implement a rawHandler
     * @param handler
     */
    public Listener(@Qualifier("rawHandler") Consumer<String> handler) {
        this.handler = handler;
    }

    @KafkaListener(id = "message-consumer", topics = "ACTIVE_FEED")
    public void processActiveFeed(String requestAction) {
        log.debug("Receiving  message");

        handler.accept(requestAction);

    }
}
