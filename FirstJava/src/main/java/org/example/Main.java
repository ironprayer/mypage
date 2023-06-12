package org.example;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    // [JDK]
    // (1) compiler : .java -> .class
    // (2) JRE
    // (3) JDB : 디버깅

    // 자바 프로젝트(앱)는 제일 먼저 클래스의 main 메서드를 실행 [ JVM의 약속 ]
    public static void main(String[] args) {

//        double doubleNumber = 10.101010;
//        float floatNumber = 10.1010f;

//        int intNumber;
//        intNumber = (int)floatNumber;
//        System.out.println("Float Type => " + floatNumber);
//        System.out.println("Init Type => " + intNumber);

//        intNumber = (int)doubleNumber;
//        System.out.println("Double Type => " + doubleNumber);
//        System.out.println("Init Type => " + intNumber);

//        int intNumber = 10;
//
//        double doubleNumber = (double) intNumber;
//        float floatNumber = (float)intNumber;

        // (1) byte -> int
        byte byteNumber = 10;
        int intNumber = byteNumber;

        // (2) char(1 byte) -> int(4) 형변환
        char charAlphabet = 'A';
        intNumber = charAlphabet;

        // (3) int -> long number 변환
        intNumber = 100;
        long longNumber = intNumber;
        System.out.println(longNumber);

        // (4) int -> double 형 변환
        intNumber = 200;
        double doubleNumber = intNumber;

        // 작은 크기의 타입이 큰 크기의 타입과 '계산'될 때,
        // 자동으로 큰 크기의 타입으로 형 변환이 된다.
        intNumber = 10;
        doubleNumber = 5.5;
        double result = intNumber + doubleNumber;

        System.out.println("Plus => " + result);

        // 1) 정수로 나누기
        int iResult = intNumber / 4;
        // 2) 실수로 나누기
        double dResult = intNumber /  4.0;

        System.out.println(iResult + " / " + dResult);

        // 요리 레시피 메모장 만들기 입력 부분
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목 : ");
        String title = scanner.nextLine();
        System.out.print("별점 : ");
        double starScore = scanner.nextDouble();
        scanner.nextLine(); // 버퍼 비우기 (enter)
        System.out.println("-----레시피 내용-----");
        String[] recipe = new String[10];

        for(int i = 0; i < 10; i++){
            System.out.print((i+1) + "번 : ");
            recipe[i] = scanner.nextLine();
        }

        // 요리 레시피 메모장 만들기 출력 부분
        System.out.println("[ " + title + " ]");
        int intStarScore = (int)starScore;
        System.out.println("별점 : " + intStarScore + " (" + ((intStarScore/5.0) * 100) + "%)" );

        for(int i = 0; i < 10; i++){
            System.out.println((i + 1) + ". " + recipe[i]);
        }
    }
}