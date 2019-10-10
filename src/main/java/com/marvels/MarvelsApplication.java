package com.marvels;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan({"com.**.dao.**"})
@ComponentScan(basePackages = {"com.marvels"})
@EnableAsync
@EnableScheduling
@ImportResource(locations = { "classpath:transaction.xml"})
public class MarvelsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarvelsApplication.class, args);
	}
}
