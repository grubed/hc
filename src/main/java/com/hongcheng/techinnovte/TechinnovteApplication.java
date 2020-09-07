package com.hongcheng.techinnovte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.hongcheng.techinnovte.mapper")
@SpringBootApplication
@EnableEurekaClient
public class TechinnovteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechinnovteApplication.class, args);
	}

}
