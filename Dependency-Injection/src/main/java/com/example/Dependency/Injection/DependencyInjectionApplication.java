package com.example.Dependency.Injection;

import com.example.Dependency.Injection.Controller.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(DependencyInjectionApplication.class, args);
		RestController controller=context.getBean(RestController.class);
		controller.sendMessage("Hello World");
		RestController controller1=context.getBean(RestController.class);
		controller1.sendMessage("Hello World from spring");

	}

}
