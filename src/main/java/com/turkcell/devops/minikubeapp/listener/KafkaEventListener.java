package com.turkcell.devops.minikubeapp.listener;

import com.turkcell.devops.minikubeapp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventListener {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    private String username;
    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload String message) {
        System.out.printf("Received Message: [%s] %n", message);

        ChatMessage chatMessage = new ChatMessage();

        if(username == null)
        {
            username="AspNet";
            //chatMessage.setType(ChatMessage.MessageType.JOIN);
            //messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        chatMessage.setSender(username);
        messagingTemplate.convertAndSend("/app/chat.sendMessage", chatMessage);
    }
}
