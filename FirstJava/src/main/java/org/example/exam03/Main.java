package org.example.exam03;

import org.example.test.MainTest;

public class Main extends  MainTest{

    public void solution(int[][] arr1) {
        String[][] answer = new String[5][5] ;
        int[][] check = arr1;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int current_number = check[i][j];
                int left_number = (j == 0) ? 0 : check[i][j-1];
                int top_number = (i == 0) ? 0 : check[i-1][j];
                int right_number = (j == 4) ? 0 : check[i][j+1];
                int under_number = (i == 4) ? 0 : check[i+1][j];

                if(current_number <= left_number || current_number <= right_number || current_number <= under_number || current_number <= top_number){
                    answer[i][j] = String.valueOf(check[i][j]);
                } else {
                    answer[i][j] = "*";
                }
            }
        }

        for(String[] line : answer){
            System.out.println(String.join(" ", line));
        }

    }

    public static void main(String[] args) {
        Main method = new Main();
        int[][] arr1 = {{7,4,6,5,9}, {6,1,3,4,5}, {4,8,5,6,9}, {1,3,0,6,4}, {6,4,8,1,7}};
        Main.main(new String[]{"sdfsdf","dsf"});

        method.solution(arr1);
        MainTest a = new MainTest();
        a.clear();
    }
}
