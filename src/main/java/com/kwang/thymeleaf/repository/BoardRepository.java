package com.kwang.thymeleaf.repository;

import com.kwang.thymeleaf.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    // 제목 검색
    List<Board> findByTitle(String title);

    // 내용검색색( like 검색)
    // %A%
    List<Board> findByContentContaining(String content);

    // 제목 또는 내용 검색
    List<Board> findByTitleOrContent(String title,String content);

    // 제목 and 내용 검색
    List<Board> findByTitleAndContent(String title,String content);

}
