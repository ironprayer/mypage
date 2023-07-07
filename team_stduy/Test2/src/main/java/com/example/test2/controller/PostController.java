package com.example.test2.controller;

import com.example.test2.dto.PostResponseDTO;
import com.example.test2.entity.Post;
import com.example.test2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    // 요청을 받아 줄 수 있는 곳 만들어줘야 줘.
    // 요청 Method + URL
    // 조회 : GET
    // 작성 : POST
    // 수정 : PUT
    // 삭제 : DELETE
    // URL => 대상이 되는 자원
    private final PostRepository postRepository;

    @GetMapping("/api/post")
    // 이 요청으로 들어왔을 경우 수행해야하는 로직을 알려줘야 하죠. => 메서드
    public List<PostResponseDTO> getPost(){
        // 제목, 작성자명, 작성 내용, 작성 날짜 => 객체로 담아서 보내줘야 한다.
        // 저 값들을 찾아와야 하죠. => DB 에서 찾아와야하죠. => DB 저희가 데이터를 저장해놨으니까.
        // Repository에서 DB를 연결하고 데이터를 가져와야지.

         List<PostResponseDTO> result = new ArrayList<>();
         List<Post> posts = postRepository.findAll();

         for(Post post : posts){
             result.add(new PostResponseDTO(post));
         }

         return result;
    }


}
