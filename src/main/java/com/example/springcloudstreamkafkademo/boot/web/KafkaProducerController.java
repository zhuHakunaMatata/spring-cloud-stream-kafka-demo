package com.example.springcloudstreamkafkademo.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyle on 2018/10/22.
 */
@RestController
public class KafkaProducerController {
    private final KafkaTemplate<String,String> kafkaTemplate;

    private String topic;

    @Autowired
    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                    @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @PostMapping("/send")
    public  Boolean sendMessage(@RequestParam String message){
        kafkaTemplate.send(topic,"meg-key",message);
        return true;
    }


}
