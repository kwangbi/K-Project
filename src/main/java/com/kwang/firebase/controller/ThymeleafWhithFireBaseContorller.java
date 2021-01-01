package com.kwang.firebase.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Thymeleaf")
public class ThymeleafWhithFireBaseContorller {

	@RequestMapping
	public String getMember(Model model) {
		String returnPage = "/firebase/list";
		
		System.out.println("111111111111111111111111111111111111111");
		
		return returnPage;
	}
	
	
	@RequestMapping(path={"/edit","/Thymeleaf/edit/{id}"})
	public String editMember(Model model,@PathVariable("id") Optional<String> USerId) {
		String returnPage = "/firebase/edit";
		
		
		
		return returnPage;		
	}
	
	@RequestMapping(path="/delete/{id}")
	public String deleteMember(Model model,@PathVariable("id") String UserId) {
		String returnPage = "redirect:/Thymeleaf/";
		
		
		System.out.println("111111111111111111111111111111111111111");
		
		
		return returnPage;		
	}
	
	@RequestMapping(path="/insert/", method = RequestMethod.POST)
	public String insertMember(Model model) {
		String returnPage = "redirect:/Thymeleaf/";
		
		
		
		return returnPage;		
	}	
		
	
}
