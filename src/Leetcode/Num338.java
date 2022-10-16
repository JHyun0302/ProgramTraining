package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num338 {
/*
    static int memo[];
    public static int[] countBits(int n) {
        int i;
        int[] val;
        val = new int[n+1];
        val[0] = 0;
        if(memo[n] != -1)
            return memo;
        if(n == 0) return val;

        val[1] = 1;
        if(n == 1) return val;

        val[2] = 1;
        if (n == 2) return val;

        for(i =3; i < val.length; i++){
            if(i % 2 == 0){
                val[i] = val[i/2];
                memo[i] = val[i];
            }
            else{
                val[i] = Math.min(val[i - 1], val[i - 2]) + 1;
                memo[i] = val[i];
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        memo = new int[n+1];
        for(int i=0;i<n+1;i++)
            memo[i] = -1;
        dp = countBits(n);
        for(int i =0; i<n+1; i++)
            System.out.println(dp[i]);
    }
*/
    public static int[] countBits(int n) {
        int[] dp = new int[n+1];
        int i;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if(n == 0)
            return dp;
        if(n == 1)
            return dp;
        if(n == 2)
            return dp;
        for(i = 3; i<= n; i++){
            if(n % 2 == 0)
                dp[n] = dp[n/2];
            else
                dp[n] = Math.min(dp[n-1],dp[n-2])+1;
        }
       return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        int res[] = new int[n+1];
        res = countBits(n);
        ArrayList ans = new ArrayList();
        for(int i =0; i<n+1; i++)
            ans.add(res[i]);
        System.out.println(ans);
    }
}
