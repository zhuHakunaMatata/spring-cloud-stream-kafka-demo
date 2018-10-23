package com.example.springcloudstreamkafkademo.boot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by kyle on 2018/10/22.
 */
@Component
public class KafkaConsumerListener {

   @KafkaListener(topics="${kafka.topic}")
    public void onMessage(String message){
        System.err.println("--kafka consumer ---------" + message);
    }

}
