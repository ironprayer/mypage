package com.sparta.backjun;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class back1940 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = 6;
        int M = 9;
        String K = "2 7 4 1 5 3";
        int start = 0;
        int end = 1;
        int result = 0;

        Object[] unique_num = Arrays.stream(K.split(" ")).sorted().toArray();

        while(start != end){
             int sum = Integer.valueOf(unique_num[start].toString()) + Integer.valueOf(unique_num[end].toString());

             if(sum < M && end < N - 1) {
                 end = end + 1;
             } else if (sum > M) {
                 start = start + 1;
             } else {
                 result = result + 1;
                 start = start + 1;
             }
        }
        System.out.println(result);
    }
}
