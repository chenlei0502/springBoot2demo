package com.example.demo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//	获取并封装当前年份跳转到登录页login.html
	@GetMapping("/toLoginPage")
	public String toLoginPage(Model model) {

		model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
		model.addAttribute("username", "admin");
		return "login";

	}

}
