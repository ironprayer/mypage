package com.example.testforidearush.sse.controller;

import com.example.testforidearush.sse.service.SseService;
import com.example.testforidearush.sse.type.SseConnect;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/sse/connect")
@RequiredArgsConstructor
public class SseController {

    private final SseService sseService;

    @GetMapping("/user")
    public SseEmitter connectUser(
            @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId) {
        long dummyUser = 1L;
        return sseService.connect(SseConnect.NOTIFICATION, dummyUser, lastEventId);
    }

    @GetMapping("/idea/{id}")
    public SseEmitter connectIdea(
            @PathVariable(name = "id") Long ideaId,
            @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId) {
        return sseService.connect(SseConnect.BID, ideaId, lastEventId);
    }
}
