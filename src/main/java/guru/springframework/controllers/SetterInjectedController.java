package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController extends BaseGreetingController {
    private GreetingService service;

    public SetterInjectedController() {
    }

    @Autowired
    @Qualifier("setterGreetingServiceImpl")
    public void setService(GreetingService service) {
        this.service = service;
    }

    @Override
    public String whatsup() {
        return service.sayHello();
    }

}
