package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Num17 {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return result;
        int length = digits.length();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int start = digits.charAt(0)-'2';
        dfs(digits, letters, result, new String(), length, start, 0);

        for(int i =0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        return result;
    }

    public static void dfs(String digits, String[] letters, List<String> result, String s, int length, int start, int idx){
        if(length==0){
            String ss = new String(s);
            result.add(ss);
            return;
        }

        for(int i=0;i<letters[start].length();i++){
            s+=letters[start].charAt(i);
            int old = start;
            if(idx<digits.length()-1)
                start  = digits.charAt(idx+1)-'2';
            dfs(digits,letters,result,s,length-1,start,idx+1);
            s= s.substring(0,s.length()-1);
            start = old;
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits);
    }
}
