package com.microservice.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceStudenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudenApplication.class, args);
	}

}
