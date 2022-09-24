package Leetcode;

public class Num397 {
    public static int integerReplacement(long n, int[] memo) {
        int cnt = 0;
        return intergerReplace(n, cnt, memo);

    }
    public static int intergerReplace(long n, int cnt, int[] memo) {
        if(memo[(int) n] != -1)
            return  memo[(int) n];
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

    public static void main(String[] args) {
        long n = 7;
        int [] memo = new int[(int) (n + 1)];
        for(int i =0; i< n+1; i++) {
            memo[i] = -1;
        }
        System.out.println("n: " + n);
        System.out.println(integerReplacement(n, memo));
    }
}
