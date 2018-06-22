package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController extends BaseGreetingController {
    @Autowired
    public GreetingService service;

    public PropertyInjectedController() {
    }

    @Override
    public String whatsup() {
        return service.sayHello();
    }
}
