package com.example.springcloudstreamkafkademo.stream.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by kyle on 2018/10/23.
 */
@Component
@EnableBinding({Sink.class})
public class MessageConsumerBean {

    @Autowired
    @Qualifier(Sink.INPUT) //bean name
    private SubscribableChannel subscribableChannel;

    @Autowired
    private Sink sink;

    @PostConstruct
    public void init(){
        subscribableChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.err.println("current thread : "+Thread.currentThread().getName() +
                " -----  subscribe : : " + message.getPayload());
            }
        });
    }

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void onMessage(Object message){
        System.err.println("@ServiceActivator : " + message);
    }

    @StreamListener(Sink.INPUT)
    public void onMessageStream(String message){
        System.err.println("@StreamListener : " + message);
    }


}
