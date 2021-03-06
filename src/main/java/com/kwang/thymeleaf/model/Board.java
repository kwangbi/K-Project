package com.kwang.thymeleaf.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    // PK

    @NotNull
    @Size(min = 2,max = 30,message = "title은 2자 이상 30자 이하 입니다.")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

}
