package Leetcode;
class Num70 {
    int [] memo = new int[46];
    public int climbStairs(int n) {
        for(int i =0; i< 46; i++)
            memo[i] = -1;

        return climb(n);
    }
    public int climb(int n) {
        if(memo[n] != -1)
            return memo[n];
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int cnt = climb(n - 1) + climb(n - 2);
        memo[n] = cnt;
        return cnt;
    }
}

