package com.serviceproviderapi

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
@ComponentScan(basePackages = "com.serviceproviderapi.controllers, com.serviceproviderapi.services.v1, com.serviceproviderapi.repositories" , basePackageClasses = RootController.class)
class ServiceProviderApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
