package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController controller;

    @Before
    public void setUp() throws Exception {
        controller = new PropertyInjectedController();
        controller.greetingServiceImpl = new GreetingServiceImpl();
    }

    @Test
    public void whatsup() {
        controller.whatsup();
    }
}