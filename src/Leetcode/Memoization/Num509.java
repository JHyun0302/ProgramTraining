package Leetcode.Memoization;

public class Num509 {
    static int ans;
    static int[] memo;
    public static int fib(int n) {
        if(memo[n] != 0)
            return memo[n];
        if(n == 0)
            return 0;
        if (n == 1)
            return 1;

        else{
            ans = fib(n-1) + fib(n-2);
            memo[n] = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        memo = new int[n+1];
        for(int i =0; i<n+1; i++)
            memo[i] = 0;
        System.out.println("fib: " + fib(n));
    }
}
