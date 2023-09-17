package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int topTotal = 0;
        int max = 0;
        float result = 0.0f;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int currentNumber = Integer.parseInt(stringTokenizer.nextToken());
            topTotal += currentNumber;

            if(max < currentNumber){
                max = currentNumber;
            }
        }

        result = (float)topTotal / max * 100 / N;
        System.out.println(result);
    }
}
