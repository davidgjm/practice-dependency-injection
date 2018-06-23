package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private GreetingService greetingService;

    @Autowired
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        String msg = greetingService.sayHello();
        System.out.println(msg);
        return msg;
    }
}
