package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.Math.abs;

public class back11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        Queue queue = new PriorityQueue<Integer>((Integer a, Integer b) -> compare(a,b));

        for(int i = 0; i < N; i++){
            int currentNum = Integer.parseInt(br.readLine());

            if(currentNum == 0){
                Integer result = queue.isEmpty() ? 0 : (Integer) queue.poll();
                System.out.println(result);
            } else {
                queue.add(currentNum);
            }
        }
    }

    public static int compare(Integer first, Integer second) {
        if(abs(first) == abs(second)) {
            return first < second ? -1 : 1;
        }

        return abs(first) < abs(second) ? -1 : 1;
    }


    // 우선순위가 더 높은 경우를 계산하기 ( 코드 확인해서 알아봐야 할듯 )
    // 음수는 첫 번째 인자가 두 번째 인자보다 낮음을 나타냄 ( 우선순위가 높음 )
    // 양수는 첫 번째 인자가 두 번째 인자보다 높음을 나타냄 ( 우선순위가 낮음 )
}
