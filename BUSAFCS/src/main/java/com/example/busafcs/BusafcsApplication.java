package com.example.busafcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.busafcs"})
@ComponentScan(basePackages = {"com.example.busafcs"})
public class BusafcsApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BusafcsApplication.class, args);
	}
	
	
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(BusafcsApplication.class);

    }


}
