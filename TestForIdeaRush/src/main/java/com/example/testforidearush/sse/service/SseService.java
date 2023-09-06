package com.example.testforidearush.sse.service;


import com.example.testforidearush.sse.type.CustomSseEmitter;
import com.example.testforidearush.sse.type.SseConnect;
import com.example.testforidearush.sse.type.SseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


@Service
@Slf4j
public class SseService {
    private static final Long DEFAULT_TIMEOUT = 1000 * 60 * 30L;
    private static final ConcurrentLinkedDeque<CustomSseEmitter> noticeEmitters = new ConcurrentLinkedDeque<>();
    private static final ConcurrentLinkedDeque<CustomSseEmitter> bidEmitters = new ConcurrentLinkedDeque<>();
    private static int count = 0;

    public SseEmitter connect(SseConnect type, Long id, String lastEventId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        ConcurrentLinkedDeque<CustomSseEmitter> currentEmitters = type == SseConnect.NOTIFICATION ? noticeEmitters : bidEmitters;
        String initMessage = type == SseConnect.NOTIFICATION ? "connect user : " + id : "connect idea : " + id;

        CustomSseEmitter customSseEmitter = new CustomSseEmitter(id, emitter);
        currentEmitters.add(customSseEmitter);

        emitter.onCompletion(() -> currentEmitters.remove(customSseEmitter));
        emitter.onTimeout(() -> {
            customSseEmitter.sseEmitter().complete();
            currentEmitters.remove(customSseEmitter);
        });
        emitter.onError(e -> {
            emitter.completeWithError(e);
            currentEmitters.remove(customSseEmitter);
        });

        try {
            emitter.send(initMessage);
        } catch (IOException e) {
            customSseEmitter.sseEmitter().completeWithError(e);
            currentEmitters.remove(customSseEmitter);
        }

        return emitter;
    }

    // SSE 연결 1,500건 일 때, 데이터를 10,000건을 연속으로 보내면 어느 순간부터 데이터를 보내는 것이 엄청 느려짐
    // 어디에서 문제가 생기는 것인지 확인이 필요함.
    // Kafka에서 데이터를 전달 받는 부분은 문제가 없어 보이니 이 부분이 문제인 것 같음.
    public void send(SseConnect type, SseEvent event, Long id, Object data) {
        ConcurrentLinkedDeque<CustomSseEmitter> currentEmitters = type == SseConnect.NOTIFICATION ? noticeEmitters : bidEmitters;
        List<CustomSseEmitter> sendEmitters = currentEmitters.stream()
                .filter((customSseEmitter) -> id.equals(customSseEmitter.id())).toList();

        for(CustomSseEmitter sendEmitter : sendEmitters) {
            try {
                sendEmitter.sseEmitter()
                        .send(SseEmitter.event()
                                .name(event.toString())
                                .data(data));
            } catch (IOException | IllegalStateException e) {
                sendEmitter.sseEmitter().completeWithError(e);
                currentEmitters.remove(sendEmitter);
            }
        }
    }

}
