package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController extends BaseGreetingController {
    private GreetingService service;

    public ConstructorInjectedController(GreetingService service) {
        this.service = service;
    }


    @Override
    public String whatsup() {
        return service.sayHello();
    }
}
