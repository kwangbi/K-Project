package com.kwang.thymeleaf.controller;

import com.kwang.thymeleaf.BoardException.BoardNotFoundException;
import com.kwang.thymeleaf.model.Board;
import com.kwang.thymeleaf.repository.BoardRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardApiController {

    private final BoardRepository boardRepository;

    public BoardApiController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/board/list")
    List<Board> all(@RequestParam(required = false,defaultValue = "") String title,
                    @RequestParam(required = false, defaultValue = "") String content){
        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)){
            return boardRepository.findAll();
        }else{
            //return boardRepository.findByTitle(title);
            return boardRepository.findByTitleOrContent(title,content);
        }
    }

    @GetMapping("/board/list/{id}")
    Board one(@PathVariable Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new BoardNotFoundException(id));
    }

    @PutMapping("/board/{id}")
    Board replaceBoard(@RequestBody Board NewBoard,@PathVariable Long id){
        return boardRepository.findById(id).map(board->{
            board.setTitle(NewBoard.getTitle());
            board.setContent(NewBoard.getContent());
            return boardRepository.save(board);
        }).orElseGet(()->{
            NewBoard.setId(id);
            return boardRepository.save(NewBoard);
        });
    }

    @DeleteMapping("/board/{id}")
    void deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
    }

}
