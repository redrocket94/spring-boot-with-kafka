package com.microservices.project.springbootwithkafka.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

// Consumer here to "consume"/use data for our system, this is for when we are expecting data and consequently what to do with said data
@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

//    Here we can make operations to the received data (message variable received in the method), currently it outputs every message consumed/received
    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
