package com.kwang.thymeleaf.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    // PK
    private String title;
    private String contents;
}
