package com.dhandapani.microservicestutorialloansms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
@ComponentScans({ @ComponentScan("com.dhandapani.microservicestutorialloansms.controller") })
@EnableJpaRepositories(basePackages = { "com.dhandapani.microservicestutorialloansms.repository" })
@EntityScan(basePackages = { "com.dhandapani.microservicestutorialloansms.model" })
public class MicroservicesTutorialLoansMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesTutorialLoansMsApplication.class, args);
	}

}
