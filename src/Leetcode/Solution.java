class Solution {
    public static boolean isSubsequence(String s, String t) {
        return subseq(s, t, 0, 0);
    }
    public static boolean subseq(String s, String t, int idx1, int idx2) {
        if(idx1 >= s.length())
            return true;
        else if(idx2 >= t.length())
            return false;
        else {

            if(s.charAt(idx1) == t.charAt(idx2)){

                return subseq(s, t, idx1+1, idx2 +1);
            }

            else
                return subseq(s, t, idx1, idx2+1);
        }
    }
}