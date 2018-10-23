package com.example.springcloudstreamkafkademo.stream.web;

import com.example.springcloudstreamkafkademo.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyle on 2018/10/23.
 */
@RestController
public class StreamKafkaProducerController {

    private MessageProducerBean messageProducerBean;
    //private String topic;

    @Autowired
    public StreamKafkaProducerController(MessageProducerBean messageProducerBean
                                        /* @Value("${kafka.topic}") String topic*/) {
        this.messageProducerBean = messageProducerBean;
//        this.topic=topic;
    }

    @GetMapping("/send/message/stream")
    public boolean sendMessage(@RequestParam String message){
        this.messageProducerBean.sendMessage(message);
        return true;
    }

    @GetMapping("/send/message/stream/kyle")
    public boolean sendMessageKyle(@RequestParam String message){
        this.messageProducerBean.sendMessageKyle(message);
        return true;
    }
}
