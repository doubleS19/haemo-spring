package com.example.haemo.haemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource("classpath:/url.properties")
public class HaemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaemoApplication.class, args);
	}
}
