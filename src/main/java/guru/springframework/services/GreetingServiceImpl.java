package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    private static final String MESSAGE = "Hello there! from greetingService";
    @Override
    public String sayHello() {
        System.out.println(MESSAGE);
        return MESSAGE;
    }
}
