package com.kwang.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/themeleaf")
	public String themeleaf(HttpServletResponse res) throws IOException{
		return "themeleaf/index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("name","aaaa");
		return "test";
	}
	
}
