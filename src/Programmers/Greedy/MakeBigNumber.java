package Programmers.Greedy;

public class MakeBigNumber {
    public static void solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int i, j, h;
        int len = number.length() - k; // return값의 자릿수
        int max = Integer.MIN_VALUE;
        int idx =0;

        for(h = 0; h < len; h++){
            max = Integer.MIN_VALUE;
            for(j = idx; j< h+ k +1; j++) {
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }
            answer.append(max);
        }


        System.out.println(answer);
        //return answer.toString();
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


/*
leetcode
605
807
        1753*/
