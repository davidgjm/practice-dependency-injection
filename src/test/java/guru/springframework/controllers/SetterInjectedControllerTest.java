package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetterInjectedControllerTest {
    private SetterInjectedController controller;

    @Before
    public void setUp() throws Exception {
        controller = new SetterInjectedController();
        this.controller.setService(new GreetingServiceImpl());
    }

    @Test
    public void whatsup() {
        controller.whatsup();
    }
}