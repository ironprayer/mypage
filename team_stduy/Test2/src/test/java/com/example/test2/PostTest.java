package com.example.test2;

import com.example.test2.entity.Post;
import com.example.test2.repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostTest {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void PostTest() throws JsonProcessingException {
        Post post = postRepository.findById(1L).orElseThrow(
                () -> new IllegalArgumentException()
        );

        String tempText = mapper.writeValueAsString(post);
    }
}
