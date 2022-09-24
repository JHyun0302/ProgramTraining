package Leetcode;

class Solution {
    public static int integerReplacement(int n) {
        long [] memo = new long[(n + 1)];
        for(int i =0; i< n+1; i++) {
            memo[i] = -1;
        }
        int cnt = 0;
        long result = intergerReplace(n, cnt, memo);
        return (int)result;

    }
    public static long intergerReplace(long n, int cnt, long[] memo) {
        if(memo[(int) n] != -1)
            return memo[(int) n];
        if (n == 1) {
            return cnt;
        }
        if(n % 2 == 0) {
            cnt += 1;
            memo[(int)n] = intergerReplace(n/2, cnt,memo);
            return intergerReplace(n/2, cnt,memo);
        }
        else {
            cnt += 1;
            memo[(int)n] = Math.min(intergerReplace(n-1, cnt,memo), intergerReplace(n+1, cnt,memo));
            return Math.min(intergerReplace(n-1, cnt,memo), intergerReplace(n+1, cnt,memo));
        }
    }
}
