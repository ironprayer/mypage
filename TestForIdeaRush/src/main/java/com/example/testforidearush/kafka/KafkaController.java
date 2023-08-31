package com.example.testforidearush.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaService kafkaService;

    @GetMapping("/test/kafka")
    void test(
            @RequestParam(name="msg") String msg
    ){
        kafkaService.sendMessage(msg);
    }
}
