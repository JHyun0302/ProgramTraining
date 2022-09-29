package Leetcode;

class Num392 {
    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int a = 1; //true
        int b = 0; //false
        int temp = 0;
        boolean memo[][] = new boolean[m+1][n+1];
        for(int i =0;i<m+1;i++)
            for(int j =0; j<n+1;j++)
                memo[i][j] = false;

        return subseq(s, t, m, n, memo);

    }
    public static boolean subseq(String s, String t, int idx1, int idx2, boolean[][] memo) {
        boolean result = false;
        if (idx1 != 0 && idx2 <= 0)
            return false;
        else if (idx1 <= 0)
            return true;
        if(memo[idx1][idx2] == true)
            return memo[idx1][idx2];

        else {
            if(s.charAt(idx1-1) == t.charAt(idx2-1)){
                result = subseq(s, t, idx1-1, idx2 -1, memo);
            }

            else {
                result = subseq(s, t, idx1, idx2 - 1, memo);
            }
        }
        memo[idx1][idx2] = result;
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence(s, t);
    }
}
