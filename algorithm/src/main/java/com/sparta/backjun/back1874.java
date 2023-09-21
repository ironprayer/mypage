package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class back1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int currentIndex = 0;
        int currentNum = 1;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        while(currentNum <= N + 1) {
            if(currentIndex == array.length) break;
            int currentValue = array[currentIndex];

            if(stack.empty()){
                stack.add(currentNum++);
                result.add("+");
            }

            if(stack.peek().equals(currentValue)) {
                stack.pop();
                result.add("-");
                currentIndex++;
            } else {
                stack.add(currentNum++);
                result.add("+");
            }

        }

        if(stack.empty()){
            for(String value : result){
                System.out.println(value);
            }
        } else {
            System.out.println("NO");
        }

    }
}
