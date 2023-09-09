package com.sparta.backjun;

import java.util.Scanner;

public class back2018 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int halfLength = N % 2 == 0 ? (N / 2) : (N / 2) + 1;
        int[] halfOfNumbers = new int[halfLength];
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 1;

        for (int i = 0; i < halfOfNumbers.length; i++) {
            halfOfNumbers[i] = i + 1;
        }

        while(start < halfOfNumbers.length){
            if (end + 1 == halfOfNumbers.length){
                if(N == sum) count++;
                sum -= halfOfNumbers[start++];
                continue;
            }

            if ( N > sum) {
                sum += halfOfNumbers[++end];
            } else if( N == sum ) {
                count++;
                sum -= halfOfNumbers[start++];
            } else if (N < sum) {
                sum -= halfOfNumbers[start++];
            }
        }
        if(N != 1) {
            count++;
        }
        System.out.println(count);
    }
}