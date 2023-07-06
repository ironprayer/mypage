package org.example.week03;

import java.io.IOException;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) throws IOException{
        solution(626331);
    }

    public static int getSize(List<Integer> a){
        return a.size();
    };
    public static int solution(int num) throws IOException {
        int answer = 0;
        int count = 0;

        try{

        } catch (Exception e){
            new Throwable(e);
        }
//        return 0;
        return 0;

    }

    public void e() {
        getSize(new A());
        getSize(new B());

        // C라는 형태 , C의 크기만큼 컴퓨터 너가 읽어야 돼
        C c = new A();

    }


    public int getSize(C c){
        return c.size();
    }

    public class A implements C {
        @Override
        public int size(){
            return 0;
        }

        public void test() {
            System.out.println("test");
        }
    }

    public class B implements C{
        @Override
        public int size(){
            return 1;
        }
    }

    public interface C {
        public int size();
    }

}
