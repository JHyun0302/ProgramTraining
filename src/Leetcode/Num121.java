package Leetcode;

public class Num121 {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int i,j;
        int len = prices.length;
        int ans =0;
        dp = new int[len+1][len+1];

        for(i = 1; i<=len;i++){
            dp[i][0] = prices[i-1];
            dp[0][i] = prices[i-1];
        }
        for(i=1;i<= len;i++){
            for(j=1;j<= len; j++){
                if(i<j)
                    dp[i][j] = -dp[i][0] + dp[0][j];
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}

