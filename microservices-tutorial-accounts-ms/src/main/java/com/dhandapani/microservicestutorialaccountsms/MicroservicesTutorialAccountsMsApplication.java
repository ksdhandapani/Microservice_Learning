package com.dhandapani.microservicestutorialaccountsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
@EnableJpaRepositories(basePackages = { "com.dhandapani.microservicestutorialaccountsms.repository" })
@EntityScan(basePackages = { "com.dhandapani.microservicestutorialaccountsms.model" })
public class MicroservicesTutorialAccountsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesTutorialAccountsMsApplication.class, args);
	}

}
