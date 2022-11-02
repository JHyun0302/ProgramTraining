package Leetcode.Greedy;

import java.util.Stack;

public class Num921 {
    public static int minAddToMakeValid(String s) {
        int answer = 0;
        int idx = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' && stack.size() >0 && stack.peek() == '(')
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        answer = stack.size();
        return answer;
    }

    public static void main(String[] args) {
        int answer = minAddToMakeValid("())");
        System.out.println(answer);
    }
}
