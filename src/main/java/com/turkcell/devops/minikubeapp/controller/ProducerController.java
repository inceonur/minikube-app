package com.turkcell.devops.minikubeapp.controller;


import com.turkcell.devops.minikubeapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer/api")
public class ProducerController {
    @Autowired
    private ProducerService service;
    @RequestMapping(value="/greet", method= RequestMethod.GET)
    public String greet() {
        return "Welcome Java App!";
    }
    @GetMapping("/message/{message}")
    public String message(@PathVariable String message) {
        service.sendMessage(message);
        return "Message sent!";
    }

}