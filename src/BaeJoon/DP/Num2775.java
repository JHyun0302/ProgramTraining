package BaeJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2775 {
    static int testCase;
    static int[] dp;
    static int[][] apt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        while (testCase >0){
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            dp = new int[ho];
            apt = new int[15][15];

            for(int i =0; i< 15; i++){
                apt[i][1] = 1; // 각 층 1호에 사는 사람
                apt[0][i] = i; // 0층에 사는 사람들
            }

            for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
                for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }
            System.out.println(apt[floor][ho]);

            testCase--;
        }
    }
}
