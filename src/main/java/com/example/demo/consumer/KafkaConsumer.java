package com.example.demo.consumer;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    //topic name and group id
    @KafkaListener(topics = "kafka_project", groupId = "group_id")
    public void consume(String message){
        System.out.println("message:"+message + " ");
    }

}
