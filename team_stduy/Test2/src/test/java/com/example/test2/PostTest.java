package com.example.test2;

import com.example.test2.dto.PostResponseDTO;
import com.example.test2.entity.Post;
import com.example.test2.repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("builder Test")
    public void customBuilderTest(){
        PostResponseDTO postResponseDTO =  PostResponseDTO.builder()
                .content("오늘 밤 아름다운 별")
                .title("오늘 밤")
                .build();

        System.out.println(postResponseDTO);
    }

    @Test
    @DisplayName("Enum Test")
    public void customEnumTest(){
        String user = Auth.USER.getAuthority();
        String admin = Auth.ADMIN.getAuthority();

        Assertions.assertEquals("ROLE_USER", user);
        Assertions.assertEquals("ROLE_ADMIN", admin);
    }
}
