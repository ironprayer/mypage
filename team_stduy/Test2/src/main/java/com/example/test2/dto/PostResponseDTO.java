package com.example.test2.dto;

import com.example.test2.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponseDTO {
    // 제목, 작성자명, 작성 내용, 작성 날짜
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;

    public PostResponseDTO(Post post){
        this.title = post.getTitle();
        this.writer = post.getWriter();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
    }
}
