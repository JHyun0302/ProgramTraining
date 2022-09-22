package Leetcode;
class Num70 {
        int [] memo = new int[46];
        public int climbStairs(int n) {
            if (n == 0)
                return 1;
            if (n < 0)
                return 0;
            if (memo[n] > 0)
                return memo[n];
            int cnt = climbStairs(n - 1) + climbStairs(n - 2);
            memo[n] = cnt;
            return cnt;
        }
}


