package org.example.exam02;

public class Main {
    public void solution(int star) {
        int arr_len = 1 + (star - 1) * 2;
        char[][] star_array = new char[star][arr_len];
        int offset = 0;
        int mid = arr_len / 2;

        for(int i = 0; i < star; i++){
            for(int j = 0; j < arr_len; j++){
                if((j < mid - offset) || (j > mid + offset)){
                    star_array[i][j] = ' ';
                } else {
                    star_array[i][j] = '*';
                }

            }
            offset += 1;
        }

        for (char[] star_line : star_array) {
            for(char element : star_line){
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main method = new Main();
        int star = 5;
        method.solution(star);
    }
}
