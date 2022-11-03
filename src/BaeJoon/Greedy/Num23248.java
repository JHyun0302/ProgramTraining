package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*public class Num23248 {
    public static int THR(int[][] arr, int m, int n, int k){
        int answer = k;
        int i, j;
        int[][] idx = new int[k][2];
        int index =0;
        for(i =0; i< arr.length; i++){
            for(j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1){
                    idx[index][0] = i;
                    idx[index++][1] = j;
                }
            }
        }

*//*        for(i =0; i< idx.length; i++){
            for(j =0; j< idx[0].length; j++)
                System.out.print(idx[i][j] + " ");
            System.out.println();
        }*//*

        for(i =0; i< idx.length; i++){
            for(j=i+1; j<idx.length; j++){
                if(idx[i][0]+ 1 == idx[j][0] && idx[i][1]+ 1 == idx[j][1] ){
                    answer--;
                }
                else if(idx[i][0]+ 1 == idx[j][0]  && idx[i][1] == idx[j][1] ){
                    answer--;
                }
                else if(idx[i][0] == idx[j][0]  && idx[i][1]+ 1 == idx[j][1] ){
                    answer--;
                }
            }
        }

*//*        for(i =0; i< idx.length; i++){
            for(j =0; j< idx[0].length; j++)
                System.out.print(idx[i][j] + " ");
            System.out.println();
        }

        System.out.println(answer);*//*
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
        for(i =0; i< arr.length; i++){
            for(j =0; j< arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        int answer = THR(arr, m,n,k);
    }
}*/
public class Num23248 {
    public static int THR(int[][] idx, int m, int n, int k){
        int answer = k;
        int i, j;
        boolean visited[] = new boolean[idx.length];
        Arrays.sort(idx, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1]; //행이 같으면 열 비교
                }else
                    return o1[0]-o2[0]; // 행이 다르면 행 기준 오름차순

            }
        });

/*        for(i =0; i< idx.length; i++){ //정렬 완료
            for(j =0; j< idx[0].length; j++)
                System.out.print(idx[i][j] + " ");
            System.out.println();
        }*/

        for(i =0; i< idx.length; i++){
            for(j=i+1; j<idx.length; j++){
                if(idx[i][0] == idx[j][0] && idx[i][1] <= idx[j][1] && visited[j] == false){
                    answer--;
                    visited[j] = true;
                }
                else if(idx[i][0] < idx[j][0]  && idx[i][1] <= idx[j][1] && visited[j] == false ){
                    answer--;
                    visited[j] = true;
                }

            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] idx = new int[k][2];
        int i, j;
        for(i =0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            idx[i][0] = a-1;
            idx[i][1] = b-1;
        }
/*        for(i =0; i< idx.length; i++){
            for(j =0; j< idx[0].length; j++)
                System.out.print(idx[i][j] + " ");
            System.out.println();
        }*/

        int answer = THR(idx, m,n,k);
    }
}