package com.example.testforidearush.Excutor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExecutorTestController {

    private final ExecutorTestService executorTestService;
    @GetMapping("test/executor")
    void executor() {
        executorTestService.test();
    }

}
