class Solution {
    public static int integerReplacement(int n) {
        int [] memo = new int[(int) (n + 2)];
        for(int i =0; i< n+2; i++) {
            memo[i] = -1;
        }
        return intergerReplace(n, memo);

    }
    public static int intergerReplace(long n, int[] memo) {
        int result;
        if(memo[(int) n] != -1)
            return  memo[(int) n];
        if (n <= 1) {
            return 0;
        }
        if(n % 2 == 0) {
            result = intergerReplace(n/2, memo) +1 ;
            memo[(int)n] = result;
        }
        else {
            result = Math.min(intergerReplace(n-1, memo), intergerReplace(n+1, memo)) + 1;
            memo[(int)n] = result;
        }
        return result;
    }
}