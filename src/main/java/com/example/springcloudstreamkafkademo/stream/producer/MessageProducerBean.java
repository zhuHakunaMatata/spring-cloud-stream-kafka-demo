package com.example.springcloudstreamkafkademo.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by kyle on 2018/10/23.
 */

@Component
@EnableBinding({Source.class,MessageSource.class})
//@EnableBinding({Source.class})
public class MessageProducerBean {

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Autowired
    private Source source;

    @Autowired
    @Qualifier(MessageSource.OUTPUT)
    private MessageChannel kyleMessageChannel;

    @Autowired
    private MessageSource messageSource;


    public boolean sendMessage(String message){
        this.messageChannel.send(MessageBuilder.withPayload(message).build());
        return true;
    }

    public boolean sendMessageKyle(String message){
        this.kyleMessageChannel.send(MessageBuilder.withPayload(message).build());
        return true;
    }

}
