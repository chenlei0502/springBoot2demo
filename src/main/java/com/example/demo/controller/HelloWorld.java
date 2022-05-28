package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorld {
	@RequestMapping("/hello")
	public String Hello() {
		return "第一个spring boot demo！！！";
	}

}
