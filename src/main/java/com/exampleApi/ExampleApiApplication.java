package com.exampleApi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApiApplication { //It acts like a configuration class by default.

	//Application's running will always start from this main() method of this @SpringBootApplication's class.
	public static void main(String[] args) {
		SpringApplication.run(ExampleApiApplication.class, args);
	}

	/* IoC will inject this object address into that reference variable where I want
       to do DI of 'ModelMapper' class & for this we use @Bean to this method. */
	@Bean //Bean in a method is declared as managed by Spring IoC.
	public ModelMapper getModelMapper() {
		return new ModelMapper(); //i.e. this method return object of ModelMapper to Spring IoC.
	}
}
