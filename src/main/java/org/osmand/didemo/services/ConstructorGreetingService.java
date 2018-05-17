package org.osmand.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {

    public static final String GREETINGS = "Hello, Good evening";

    public String sayGreeting(){
        return "Hello, this is Constructor Greeting Service.";
    }
}
