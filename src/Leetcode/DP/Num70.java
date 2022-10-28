package Leetcode.DP;
class Num70 {
        static int memo[];
        static int ans =0;
        public static int climbStairs(int n) {
            if(n == 1)
                return 1;
            if(n ==2)
                return 2;
            if(memo[n] != 0)
                return memo[n];
            else{
                ans = climbStairs(n-1) + climbStairs(n-2);
                memo[n] = ans;
            }
            return ans;
        }

        public static void main(String[] args) {
            int [] memo = new int[46];
            int n = 3;
            for(int i =0; i< memo.length; i++)
                memo[i] = 0;
            System.out.println("n: " + n);
            System.out.println(+climbStairs(n));
        }
}


