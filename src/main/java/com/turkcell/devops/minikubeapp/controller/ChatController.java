package com.turkcell.devops.minikubeapp.controller;

import com.turkcell.devops.minikubeapp.model.ChatMessage;
import com.turkcell.devops.minikubeapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    @Autowired
    private ProducerService service;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println("Sender:"+chatMessage.getSender());
        System.out.println("Type:"+chatMessage.getType());
        System.out.println("Content:"+chatMessage.getContent());
        // to Kafka
        service.sendMessage(chatMessage.getContent());

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
