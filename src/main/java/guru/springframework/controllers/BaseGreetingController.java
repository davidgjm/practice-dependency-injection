package guru.springframework.controllers;

abstract class BaseGreetingController {
    protected abstract String whatsup();

    public void sayHi() {
        System.out.println(whatsup());
    }
}
