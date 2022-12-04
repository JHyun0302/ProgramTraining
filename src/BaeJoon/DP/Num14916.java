package BaeJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14916 {
    public static int[] dp = new int[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken());
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 6; i <= money; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
            } else if (dp[i - 2] == -1) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 5] == -1) {
                dp[i] = dp[i - 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
            }
        }
        System.out.print(dp[money]);
    }
}
