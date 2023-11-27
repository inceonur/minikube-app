package com.turkcell.devops.minikubeapp.controller;


import com.turkcell.devops.minikubeapp.model.Message;
import com.turkcell.devops.minikubeapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ProducerController {
    @Autowired
    private ProducerService service;
    @RequestMapping(value="/greet", method= RequestMethod.GET)
    public String greet() {
        return "Welcome Java App v5!";
    }
    @GetMapping("/message/{message}")
    public String message(@PathVariable String message) {
        service.sendMessage(message);
        return "Message sent!";
    }
}