package com.example.test2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {
    // PK (Primary Key) 지정해주는 알려주는 어노테이션입니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목, 작성자명, 작성 내용, 작성 날짜
    // 컬럼의 제약조건이에요. 길이가 몇이어야 해, 유니크해야 해
    @Column(nullable = false)
    private String title;
    @Column
    private String writer;
    @Column
    private String content;
    @Column
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne
    private User user;

    // LocalDateTime 년 월 일 시 분 초 밀리세컨즈
    // LocalDate  년 월 일 0시 0분 0초
}
