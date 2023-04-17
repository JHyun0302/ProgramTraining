package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] number = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + number[i][j];
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (result < dp[n][i]) {
                result = dp[n][i];
            }
        }

        System.out.println(result);

    }
}
