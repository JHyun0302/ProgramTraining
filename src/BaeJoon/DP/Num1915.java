package BaeJoon.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int i, j;
        char map[][] = new char[row+1][col+1];

        for(i=0;i<row;i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] dp = new int[row+1][col+1];
        int max = 0;
/*        dp[0][0] = 0;
        for(i=1; i<= row; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }*/
        for(i=0;i<row;i++) {
            for(j=0;j<col;j++) {
                if(map[i][j]=='0') {
                    dp[i+1][j+1] = 0;
                    continue;
                }
                dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j])+1;
                max = Math.max(max, dp[i+1][j+1]);
            }
        }
        System.out.println(max*max);
    }
}
