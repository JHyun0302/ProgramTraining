package Leetcode;
class Num70 {
        public static int climbStairs(int n, int memo[]) {
            if (n == 0)
                return 1;
            if (n < 0)
                return 0;
            if (memo[n] > 0)
                return memo[n];
            int cnt = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
            memo[n] = cnt;
            return cnt;
        }

        public static void main(String[] args) {
            int [] memo = new int[46];
            int n = 5;
            System.out.println("n: " + n);
            System.out.println(+climbStairs(n, memo));
        }
}


