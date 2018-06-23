package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello from Setter Greeting Service!";
    }
}
