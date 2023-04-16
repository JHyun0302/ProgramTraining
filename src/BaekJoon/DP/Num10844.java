package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10844 {
    static Long[][] dp;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10]; //[몇 번째 자리][몇 번째 자리에 들어간 숫자]

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += recur(n, i);
        }
        System.out.println(result % MOD);
    }

    private static long recur(int n, int val) {
        if (n == 1) {
            return dp[n][val];
        }

        if (dp[n][val] == null) {
            if (val == 0) {
                dp[n][val] = recur(n - 1, 1);
            } else if (val == 9) {
                dp[n][val] = recur(n - 1, 8);
            } else {
                dp[n][val] = recur(n - 1, val - 1) + recur(n - 1, val + 1);
            }
        }
        return dp[n][val] % MOD;
    }
}
