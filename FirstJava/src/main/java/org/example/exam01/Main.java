package org.example.exam01;

public class Main {
    public String solution(int n) {
        String answer = "";
        String[] numbers = String.valueOf(n).split("");
        int sum = 0;

        for(int index = (numbers.length - 1); index >= 0; index--){
             String current_number = numbers[index];
             String operator = (index == 0) ? "=" : "+";

             answer += current_number + operator;
             sum += Integer.valueOf(current_number);
        }

        answer += sum;

        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        System.out.println(method.solution(718253));
    }
}