package Leetcode;

class Num392 {
    static public int isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int lcs = LCS(s, t, m, n);
        return lcs;
    }
    static public int LCS(String s, String t, int idx1, int idx2) {
        int[][] dp = new int[idx1 + 1][idx2 + 1];

        for (int i = 1; i < dp.length; i++) { // s(짧은 string)
            for (int j = 1; j< dp[0].length; j++){ //t(긴 string)
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[idx1][idx2];
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        int n = isSubsequence(s,t);
        System.out.println("n:" +n);
    }
}
/*public static boolean isSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    return subseq(s, t, m, n);
}
    public static boolean subseq(String s, String t, int m, int n) {
        boolean result;
        if (m != 0 && n <= 0)
            return false;
        else if (m <= 0)
            return true;
        else {
            if (s.charAt(m - 1) == t.charAt(n - 1)) {
                return subseq(s, t, m - 1, n - 1);

            } else {
                return subseq(s, t, m, n - 1);
            }
        }

    }
        public static void main (String[]args){
            String s = "abc";
            String t = "ahbgdc";
            System.out.println(isSubsequence(s, t));
        }

}*/
