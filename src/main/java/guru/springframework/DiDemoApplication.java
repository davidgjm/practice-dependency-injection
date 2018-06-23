package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(DiDemoApplication.class, args);
		MyController controller = (MyController) ctx.getBean("myController");
		controller.hello();


		ctx.getBean(PropertyInjectedController.class).sayHi();
		ctx.getBean(SetterInjectedController.class).sayHi();
		ctx.getBean(ConstructorInjectedController.class).sayHi();
	}
}
