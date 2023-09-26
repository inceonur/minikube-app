package com.turkcell.devops.minikubeapp;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @RequestMapping(value="/controller", method= RequestMethod.GET)
    public String foo() {
        return "Response!";
    }

}