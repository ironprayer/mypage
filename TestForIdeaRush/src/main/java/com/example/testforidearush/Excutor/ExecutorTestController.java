package com.example.testforidearush.Excutor;

import com.example.testforidearush.entity.Users;
import com.example.testforidearush.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExecutorTestController {

    private final ExecutorTestService executorTestService;
    private final UserRepository userRepository;

    @GetMapping("test/executor")
    void executor() {
        executorTestService.test();
    }

    @Transactional
    @GetMapping("test/isCommentAlarm")
    public void isCommentAlarm() {
        Users user = userRepository.findById(1L).get();
        user.changeAlarm();
    }

    @GetMapping("test/savaUser")
    void saveUser() {
        userRepository.save(new Users());
    }

}
