package com.kwang.thymeleaf.BoardException;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(Long id){
    super("Could not find board data : " + id);
    }
}
