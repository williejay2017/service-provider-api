package com.serviceproviderapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = "com.serviceproviderapi.controllers, com.serviceproviderapi.services.v1, com.serviceproviderapi.repositories" , basePackageClasses = RootController.class)
class ServiceProviderApiApplication {

	static void main(String[] args) {
		SpringApplication.run(ServiceProviderApiApplication, args)
	}
}
