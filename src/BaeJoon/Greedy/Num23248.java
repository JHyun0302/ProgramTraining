package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num23248 {
    public static int THR(int[][] arr, int m, int n, int k){
        int answer = 0;
        int i, j;
        int[][] idx = new int[k][2];
        for(i =0; i< idx.length; i++){
            for(j=0; j<idx[0].length; j++){
                if(arr[i][j] == 1){
                    idx[i][0] = i;
                    idx[i][1] = j;
                }

            }
        }

        for(i =0; i< idx.length; i++){
            for(j =0; j< idx[0].length; j++)
                System.out.print(idx[i][j] + " ");
            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int[][] idx = new int[k][2];
        int i, j;
        for(i =0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = 1;
        }


        int answer = THR(arr, m,n,k);
    }
}
