package com.kwang.thymeleaf.controller;

import com.kwang.thymeleaf.model.User;
import com.kwang.thymeleaf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AcountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("login")
    public String Login(){

        return "account/login";
    }


    @GetMapping("register")
    public String register(){

        return "account/register";
    }

    @PostMapping("register")
    public String register(User user){
        accountService.save(user);
        return "redirect:/";
    }


}
