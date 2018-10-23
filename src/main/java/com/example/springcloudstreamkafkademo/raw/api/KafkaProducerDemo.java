package com.example.springcloudstreamkafkademo.raw.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kyle on 2018/10/22.
 */
public class KafkaProducerDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //初始化配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        //创建 Kafka 生产者
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //创建 topic
        String topic = "gupao";
        Integer partition = 0;
        Long timestamp =System.currentTimeMillis();
        String key ="message-key";
        String value = "xiaomage";
        ProducerRecord<String,String> producerRecord =
                new ProducerRecord<String, String>(topic,partition,timestamp,key,value);

        //发送消息（异步）
        Future<RecordMetadata> metadataFuture =kafkaProducer.send(producerRecord);

        //强制执行
        metadataFuture.get();

    }
}
