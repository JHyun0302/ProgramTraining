package Leetcode;
//괄호문제
import java.util.List;
import java.util.ArrayList;
public class Num22 {
    static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n){
        helper(n, 0,0, "");
        return ans;
    }
    public static void helper(int n, int open, int close, String s){
        if(n*2 == s.length()){
            ans.add(s);
            return;
        }
        if(open < n)
            helper(n, open+1, close, s + "(");
        if(close < open)
            helper(n, open, close+1, s+")");

    }
    public static void main(String[] args) {
        int n = 3;
        List<String> gen = new ArrayList<>();
        generateParenthesis(n);
        System.out.println(ans);
    }

}
