package com.marvels.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.marvels.**.dao")
@ComponentScan(basePackages={"com.marvels"})
@ImportResource("classpath:transaction.xml")
public class TestMarvelsApproveApplication {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SpringApplication.run(TestMarvelsApproveApplication.class,args);
	}

}
