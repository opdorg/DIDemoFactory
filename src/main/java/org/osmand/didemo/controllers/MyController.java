package org.osmand.didemo.controllers;

import org.osmand.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        //System.out.print("\n\nHello........\n");
        return greetingService.sayGreeting();

    }
}
