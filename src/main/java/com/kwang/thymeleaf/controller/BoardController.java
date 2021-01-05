package com.kwang.thymeleaf.controller;

import com.kwang.thymeleaf.model.Board;
import com.kwang.thymeleaf.repository.BoardRepository;
import com.kwang.thymeleaf.service.BoardService;
import com.kwang.thymeleaf.validator.BoardValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 3) Pageable pageable
            ,@RequestParam(required = false,defaultValue = "") String searchText){

        Page<Board> boards = boardRepository.findByTitleContainingOrContentContainingOrderByIdDesc(searchText,searchText,pageable);

        int startPage = Math.max(1,boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("boards",boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String getForm(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board",board);
        }

        return "board/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Board board, BindingResult bindingResult){

        // validation check
        boardValidator.validate(board,bindingResult);

        if(bindingResult.hasErrors()){
            return "board/form";
        }

        boardService.save(board);
        return "redirect:/board/list";
    }

}
