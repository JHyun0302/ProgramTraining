package Leetcode.DP;

import java.util.ArrayList;
import java.util.List;

public class Num121 {
    static int[][] dp;
    static public int maxProfit(int[] prices) {
        int i,j;
        int len = prices.length;
        int ans =0;
        dp = new int[len+1][len+1];

        for(i = 1; i<=len;i++){
            dp[i][0] = prices[i-1]; //buy
            dp[0][i] = prices[i-1]; //sell
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

    public static void main(String[] args) {
        int i;
        int ans;
        List<Integer> prices = new ArrayList<>();
        prices.add(7);
        prices.add(1);
        prices.add(5);
        prices.add(3);
        prices.add(6);
        prices.add(4);
        int[] arr;
        int size = prices.size();
        arr = new int[size];
        for (i = 0; i < arr.length; i++)
            arr[i] = prices.get(i);
        System.out.print("arr: ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        ans = maxProfit(arr);
        System.out.print("\nMaxProfit: " + ans);
    }
}

