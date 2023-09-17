package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back11659 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] sum = new int[N];

        stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int currentNum = Integer.parseInt(stringTokenizer.nextToken());
            sum[i] = (i == 0) ? currentNum : sum[i-1] + currentNum;
        }

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int endSum = sum[end - 1];
            int startSum = (start == 1) ? 0 : sum[start - 2];
            System.out.println(endSum - startSum);
        }

    }
}
