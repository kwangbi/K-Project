package com.kwang.thymeleaf.service;

import com.kwang.thymeleaf.model.Board;
import com.kwang.thymeleaf.model.User;
import com.kwang.thymeleaf.repository.BoardRepository;
import com.kwang.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(Board board){
        // Get Spring security user info
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        String username = a.getName();

        User user = userRepository.findByUsername(username);

        board.setUser(user);

        return boardRepository.save(board);
    }


}
