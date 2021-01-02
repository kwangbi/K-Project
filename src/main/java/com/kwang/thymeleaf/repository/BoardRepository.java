package com.kwang.thymeleaf.repository;

import com.kwang.thymeleaf.model.board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<board,Long> {
}
