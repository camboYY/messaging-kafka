package com.kafka.springboot;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikiMediaChangesHandler implements EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangingProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikiMediaChangesHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("Message is going on. %s", messageEvent.getData()));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
