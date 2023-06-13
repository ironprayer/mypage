package org.example.week02;

public class W07 {
    public static void main(String[] args) {
        // 기타 연산자
        // (1) 형변환 연산자
        int intNumber = 93 + (int)98.8;
        System.out.println(intNumber);

        double doubleNumber = (double) 93 + 98.87;
        System.out.println(doubleNumber);

        // (2) 삼항 연산자

        int x = 1;
        int y = 9;

        boolean b = (x == y) ? true : false;
        System.out.println(b);

        String s = (x != y) ? "정답" : "오답";
        System.out.println(s);

        int max = ( x > y) ? x : y;
        System.out.println(max);

        int min = ( x < y) ? x : y;
        System.out.println(min);

        // (3) instance of
    }
}
