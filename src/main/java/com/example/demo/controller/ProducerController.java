package com.example.demo.controller;

import com.example.demo.entity.Employee;
import org.apache.kafka.common.internals.Topic;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class ProducerController {

    @Autowired
    KafkaTemplate<String, Employee> kafkaTemplate;

    private static final String TOPIC="kafka_project";

    @PostMapping("/publish")
    public String publishEmployee(@RequestBody Employee employee){
        kafkaTemplate.send(TOPIC,employee);
        return "publish successful";
    }
}
