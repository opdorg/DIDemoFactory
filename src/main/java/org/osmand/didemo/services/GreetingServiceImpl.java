package org.osmand.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETINGS = "Hello, Good evening";

    @Override
    public String sayGreeting() {
        return GREETINGS;
    }
}
