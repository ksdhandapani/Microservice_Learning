package com.dhandapani.microservicestutorialcardsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
@ComponentScans({ @ComponentScan("com.dhandapani.microservicestutorialcardsms.controller") })
@EnableJpaRepositories(basePackages = { "com.dhandapani.microservicestutorialcardsms" })
@EntityScan(basePackages = { "com.dhandapani.microservicestutorialcardsms" })
public class MicroservicesTutorialCardsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesTutorialCardsMsApplication.class, args);
	}

}
