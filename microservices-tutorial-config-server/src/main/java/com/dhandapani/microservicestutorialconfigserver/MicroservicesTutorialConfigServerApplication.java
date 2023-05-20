package com.dhandapani.microservicestutorialconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
/* 
 * Makes our microservice / spring boot application into a config 
 * server which can read configurations from a centralized repositories 
 * and expose all our properties through rest endpoints.
 */
@EnableConfigServer
public class MicroservicesTutorialConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesTutorialConfigServerApplication.class, args);
	}

}
