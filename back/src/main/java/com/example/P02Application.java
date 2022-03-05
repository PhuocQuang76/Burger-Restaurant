package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class P02Application {

	public static void main(String[] args) {
		SpringApplication.run(P02Application.class, args);
	}

}
