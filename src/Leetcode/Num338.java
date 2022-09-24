package Leetcode;

public class Num338 {
    public static int[] countBits(int n, int memo[]) {
        int[] dp = new int[n + 1];
        if(memo[n] != -1)
            return memo;

        dp[0] = 0;
        if (n == 0) return dp;

        dp[1] = 1;
        if (n == 1) return dp;

        dp[2] = 1;
        if (n == 2) return dp;

        for (int i = 3; i < dp.length; i++) {
            if (i % 2 == 0)
                dp[i] = dp[i / 2];
            else
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + 1;
        }
        memo = dp;
        System.out.println(memo);
        return dp;
    }
    public static void main(String[] args) {
        int n = 5;
        int [] memo = new int[n+1];
        for(int i =0; i< n+1; i++)
            memo[i] = -1;
        System.out.println("n: " + n);
        System.out.println(countBits(n, memo));
    }
}
