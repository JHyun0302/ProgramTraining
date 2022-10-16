package Leetcode;

class Num392 {
/*    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int a = 1; //true
        int b = 0; //false
        int temp = 0;
        return subseq(s, t, m, n);

    }
    public static boolean subseq(String s, String t, int idx1, int idx2) {
        boolean result = false;
        if (idx1 != 0 && idx2 <= 0)
            return false;
        else if (idx1 <= 0)
            return true;

        else {
            if(s.charAt(idx1-1) == t.charAt(idx2-1)){
                result = subseq(s, t, idx1-1, idx2 -1);
            }

            else {
                result = subseq(s, t, idx1, idx2 - 1);
            }
        }
        return result;
    }*/
public static boolean isSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    return subseq(s, t, m, n);
}
static int temp =0;
    public static boolean subseq(String s, String t, int m, int n) {
        boolean result;
        if (temp == m)
            return true;
        else if (m != 0 && n <= 0)
            return false;
        else if (m <= 0)
            return true;
        else {
            if (s.charAt(m - 1) == t.charAt(n - 1)) {
                temp += 1;
                System.out.println(temp);
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

}
