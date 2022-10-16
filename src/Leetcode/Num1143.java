package Leetcode;

class Num1143 {
       public static int LCS(String X, String Y, int m, int n){
           int a,b;
           int result = 0;
           char[] X_char = X.toCharArray();
           char[] Y_char = Y.toCharArray();
           if(m == 0 || n ==0){
               result = 0;
           }
           else if(X_char[m-1] == Y_char[n-1])
               result = LCS(X, Y, m-1, n-1) + 1;
           else {
               a = LCS(X, Y, m - 1, n);
               b = LCS(X, Y, m, n - 1);
               if (a > b)
                   result = a;
               else
                   result = b;
           }
           return result;
       }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abc";
        int m = text1.length();
        int n = text2.length();
        int result = 0;
        result = LCS(text1, text2,m,n);
        System.out.println("result: " +result);
    }
}
