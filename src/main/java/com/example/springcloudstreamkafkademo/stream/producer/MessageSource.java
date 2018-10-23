package com.example.springcloudstreamkafkademo.stream.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * Created by kyle on 2018/10/23.
 */
public interface MessageSource {
    String OUTPUT = "kyleOutput";

    @Output(MessageSource.OUTPUT)
    MessageChannel kyleOutput();
}
