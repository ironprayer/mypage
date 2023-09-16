package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        String numStr = br.readLine();
//        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), "");

        for(int i = 0; i < N; i++){
            result += Integer.parseInt(numStr.substring(i, i+1));
        }

        System.out.println(result);
    }
}
