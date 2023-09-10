package com.example.testforidearush.Excutor;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExecutorTestController {

    private final ExecutorTestService executorTestService;
//    private final UserRepository userRepository;

    @GetMapping("test/executor")
    void executor() {
        executorTestService.test();
    }


}
