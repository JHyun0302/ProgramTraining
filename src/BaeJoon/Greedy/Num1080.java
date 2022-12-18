package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1080 {

    static int row;
    static int col;
    static int arrA[][];
    static int arrB[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arrA = new int[row][col];
        arrB = new int[row][col];

        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }

        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }


    }
}
