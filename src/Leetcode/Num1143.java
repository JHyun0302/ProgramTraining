package Leetcode;

class Num1143 {
    /*   public int LCS(String X, String Y, int m, int n, int[][] memo){
           int a,b;
           int result = 0;
           char[] X_char = X.toCharArray();
           char[] Y_char = Y.toCharArray();
           if(memo[m][n] != -1) {
               return memo[m][n];
           }
           if(m == 0 || n ==0){
               result = 0;
               memo[m][n] = result;
           }
           else if(X_char[m-1] == Y_char[n-1]){
               result = LCS(X, Y, m-1, n-1, memo) + 1;
               memo[m][n] = result;
           }
           else {
               a = LCS(X, Y, m - 1, n, memo);
               b = LCS(X, Y, m, n - 1, memo);
               if (a > b) {
                   result = a;
                   memo[m][n] = result;
               } else {
                   result = b;
                   memo[m][n] = result;
               }
           }
           memo[m][n] = result;
           return result;
       }
       public int longestCommonSubsequence(String text1, String text2) {
           int m = text1.length();
           int n = text2.length();
           int memo[][] = new int[m+1][n+1];
           for(int i =0; i< m+1; i++)
               for(int j =0; j< n+1; j++)
                   memo[i][j] = -1;
           return LCS(text1, text2, m,n, memo);
       }*/
    static int i, j = 0;

    static int ans = 0;
    static int chk = 0;

    public static int longestCommonSubsequence(char[] text1_char, char[] text2_char, int idx1, int idx2) {
        while(true){
        if (idx2 >= text2_char.length)
            break;
        if (text1_char[idx1] != text2_char[idx2]) { //다른경우
            if (idx1 >= text1_char.length) {
                idx2++;
                idx1 = chk;
            }

            longestCommonSubsequence(text1_char, text2_char, idx1+1, idx2);
        } else { //같은 경우
            ans++;
            chk = idx1+1;
            longestCommonSubsequence(text1_char, text2_char, idx1 + 1, idx2 + 1);
        }
    }
        return ans;
}

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abc";
        int m = text1.length();
        int n = text2.length();
        char[] text1_char = text1.toCharArray();
        char[] text2_char = text2.toCharArray();
        int result = 0;
        result = longestCommonSubsequence(text1_char, text2_char,0,0);
        System.out.println("result: " +result);
    }
}
