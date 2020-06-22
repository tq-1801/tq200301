package com.hqyj.size;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScClientSizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScClientSizeApplication.class, args);
	}

}
