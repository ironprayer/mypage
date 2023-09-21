package com.sparta.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back12891 {

    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int P = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<Character, Integer> currentCount = new HashMap<>();
        HashMap<Character, Integer> answer = new HashMap<>();
        char[] dnaChars = {'A', 'C', 'G', 'T'};

        char[] dna = br.readLine().toCharArray();
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < dnaChars.length; i++){
            char dnaChar = dnaChars[i];
            currentCount.put(dnaChar, 0);
            answer.put(dnaChar, Integer.parseInt(stringTokenizer.nextToken()));
        }

        for(int i = 0; i < S; i++){
            char currentChar = dna[i];
            currentCount.put(currentChar, currentCount.get(currentChar) + 1);
        }
        if(isMatch(currentCount, answer)) {
            result++;
        }

        for(int i = S - 1; i < P - 1; i++){
            char addChar = dna[i + 1];
            char removeChar = dna[i + 1 - S];

            currentCount.put(addChar, currentCount.get(addChar) + 1);
            currentCount.put(removeChar, currentCount.get(removeChar) - 1);

            if(isMatch(currentCount, answer)){
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isMatch(HashMap<Character, Integer> current, HashMap<Character, Integer> answer) {
         Set<Character> keys = answer.keySet();

         for(Character key : keys){
             if(answer.get(key).intValue() > current.get(key).intValue()){
                 return false;
             }
         }
         return true;
    }

}
