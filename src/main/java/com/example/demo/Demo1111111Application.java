package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.demo.service.persistence")
@SpringBootApplication
@EnableCaching
public class Demo1111111Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo1111111Application.class, args);
	}
}
