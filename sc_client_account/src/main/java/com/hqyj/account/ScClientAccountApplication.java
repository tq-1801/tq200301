package com.hqyj.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScClientAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScClientAccountApplication.class, args);
	}

}
