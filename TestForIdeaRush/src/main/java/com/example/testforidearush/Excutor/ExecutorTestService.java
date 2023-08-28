package com.example.testforidearush.Excutor;

import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ExecutorTestService {

    // newSingleThreadExecutor()로 생성되는 BlockingQueue의 크기는 Integer.MAX(0x7fffffff) 이다
    private final static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void test() {
        System.out.println("시작 : " + Thread.currentThread().getName() + " ," + Thread.currentThread().getId());

        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName() + " ," + Thread.currentThread().getId());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        executorService.submit(task1);
        System.out.println("종료 : " + Thread.currentThread().getName() + " ," + Thread.currentThread().getId());
    }
}
