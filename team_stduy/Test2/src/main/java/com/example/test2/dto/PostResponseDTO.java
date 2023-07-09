package com.example.test2.dto;

import com.example.test2.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
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

    public PostResponseDTO(String title, String writer, String content, LocalDateTime createdAt) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static PostResponseDtoBuilder builder() {
        return new PostResponseDtoBuilder();
    }

    public static class PostResponseDtoBuilder {
        private String title;
        private String writer;
        private String content;
        private LocalDateTime createdAt;

        public PostResponseDtoBuilder title(String title){
            this.title = title;
            return this;
        }

        public PostResponseDtoBuilder writer(String writer){
            this.writer = writer;
            return this;
        }

        public PostResponseDtoBuilder content(String content){
            this.content = content;
            return this;
        }

        public PostResponseDtoBuilder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public PostResponseDTO build(){
            return new PostResponseDTO(title, writer, content, createdAt);
        }
    }
}
