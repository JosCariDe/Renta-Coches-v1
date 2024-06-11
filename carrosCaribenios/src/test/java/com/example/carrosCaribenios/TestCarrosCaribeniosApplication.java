package com.example.carrosCaribenios;

import org.springframework.boot.SpringApplication;

public class TestCarrosCaribeniosApplication {

	public static void main(String[] args) {
		SpringApplication.from(CarrosCaribeniosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
