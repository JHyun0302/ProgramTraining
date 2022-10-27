package Programmers.Greedy;

public class Greedy {
    public static void solution(String number, int k) {
        String answer = "";
        int i, j;
        int[] arr = new int[number.length()];
        for(i =0; i<arr.length;i++){
            arr[i] = number.charAt(i) - '0';
        }
        int len = number.length() - k;
        int max = Integer.MIN_VALUE;
        int creat_val;
        int idx =0;
        int[] temp = new int[len];
        for(i =0; i < len; i++){
            if(max < arr[i]){
                temp[0] = arr[i];
                idx = i;
            }
        }
        for(j = idx; j< len; j++){
            temp[1] =
            /*
            System.out.println(creat_val);
            max = Math.max(max, creat_val);*/
        }
        System.out.println("MAX: " + max);
        answer = Integer.toString(max);
        //return answer;
    }

    public static void main(String[] args) {
        solution("4177252841", 4);
    }

}

/*
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] arr = new int[answer.length()];
        for(int i =0; i<answer.length();i++)
            arr[i] = answer.charAt(i) - '0';
        int max = Integer.MIN_VALUE;
        int creat_val;
        for(int i =0; i < arr.length; i++){
            for(int j =0; j< i; j++){
                creat_val = arr[j] * 10 + arr[i];
                max = Math.max(max, creat_val);
            }
        }
        answer = String.valueOf(max);
        return answer;
    }
}
*/
leetcode
605
807
        1753