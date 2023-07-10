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

         // dirthy Checking이 필요하다면 영속성 컨텍스트가 필요하죠. => 1차 캐시에서 그 기능 제공해주고 있어요. (객체명, 객체, DB데이터(스냅샷))
         // => 영속성 컨텍스트 끝나면서 현재 객체와 스냅샷을 비교해서 달라진게 있으면 업데이트를 날립니다. 이게 dirthy checking이에요.
         // => transactional이랑 같이 만들어진다고 생각하시면 됩니다.


         return result;
    }


}
