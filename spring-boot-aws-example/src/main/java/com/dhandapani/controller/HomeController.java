package com.dhandapani.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(path = "/home")
	public String sayHello() {
		return "Your application is hosted on AWS.....!!!";
	}

}
