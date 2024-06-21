// start again with this video to understand clearly again
// : https://www.youtube.com/watch?v=ET39IFffr24&list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF&index=7

// This project is started from https://start.spring.io/ website with maven build system and with no dependencies and
// choosing jar packaging

// Open the generated file from IDE(UNZIP the file first)


package com.Pranay.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {


		/*
		 This line SpringApplication.run(MyAppApplication.class, args)  creates the IOC container
		inside the JVM of the machine where spring stores all the objects of the
		classes that we specify to create the object and manages them
		 */

		/*
		Spring Ioc container itself is an object(everything is objects in java). So we need a variable(context) that
		stores Spring Ioc container object,
		So that we can the context to get which object is needed.  Spring Ioc container is of type ApplicationContext
		in spring
		 */

		/*
		This SpringApplication.run(MyAppApplication.class, args) will return an object of type
		ApplicationContext. To verify that decouple the code by going into run() method which
		returns obj of type ConfigurableApplicationContext. If we go into
		ConfigurableApplicationContext class then we can see it Extends ApplicationContext Which means
		run method extends all the properties and behaviours of ApplicationContext and can
		return of that type
		 */

		ApplicationContext context =  SpringApplication.run(MyAppApplication.class, args);

		//By using the context obj(IOC container reference) we should call the getBean() method with the class we
		// need the obj of. In the below case we used Dev class. Also, we need add @Component annotation on top the
		// class that needs a object to be created and handled by Spring
		Dev obj = context.getBean(Dev.class);

		obj.build();

	}

}
