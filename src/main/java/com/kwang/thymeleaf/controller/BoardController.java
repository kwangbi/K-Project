package com.kwang.thymeleaf.controller;

import com.kwang.thymeleaf.model.board;
import com.kwang.thymeleaf.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){

        List<board> boards = boardRepository.findAll();
        model.addAttribute("boards",boards);


        return "board/list";
    }

}
