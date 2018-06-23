package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController extends BaseGreetingController {
    @Autowired
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingServiceImpl;

    public PropertyInjectedController() {
    }

    @Override
    protected String whatsup() {
        return greetingServiceImpl.sayHello();
    }
}
