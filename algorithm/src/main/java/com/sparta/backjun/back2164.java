package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class back2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue queue = new ArrayDeque();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.poll();

            int safeValue = (Integer) queue.poll();
            queue.add(safeValue);
        }

        System.out.println(queue.poll());
    }
}
