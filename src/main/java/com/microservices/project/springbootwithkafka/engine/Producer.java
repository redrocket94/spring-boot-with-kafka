package com.microservices.project.springbootwithkafka.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// Producer here to "produce"/send data for another system, this is for when we are sending data and consequently *which* data
@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        // TODO Build message to send here when requested


        logger.info(String.format("Sending requested message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}