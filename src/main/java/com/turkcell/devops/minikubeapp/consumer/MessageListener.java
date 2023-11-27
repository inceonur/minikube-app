package com.turkcell.devops.minikubeapp.consumer;

import com.turkcell.devops.minikubeapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    SimpMessagingTemplate template;
    @KafkaListener(
            topics = "${spring.kafka.producer.topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener..");
        template.convertAndSend("/topic/group", message);
    }
}