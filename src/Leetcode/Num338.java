package Leetcode;

public class Num338 {
    public static int[] countBits(int n) {
        int i;
        int[] val;
        val = new int[n+1];
        val[0] = 0;
        if(n == 0) return val;

        val[1] = 1;
        if(n == 1) return val;

        val[2] = 1;
        if (n == 2) return val;

        for(i =3; i < val.length; i++){
            if(i % 2 == 0)
                val[i] = val[i/2];
            else
                val[i] = Math.min(val[i - 1], val[i - 2]) + 1;
        }
        return val;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        dp = countBits(n);
        for(int i =0; i<n+1; i++)
            System.out.println(dp[i]);
    }

}
