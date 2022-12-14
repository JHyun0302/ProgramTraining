package Leetcode.Greedy;


public class Num1689 {
    public static int minPartitions(String n) {
        /**
         * n의 각 자리 숫자를 받아서 number에 각자리를 저장
         * 각 자리 숫자를 비교해서 가장 큰 숫자가 정답
         */
        int[] number = new int[n.length()];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n.length(); i++) {
            number[i] = n.charAt(i) - '0';
        }

        for (int i = 0; i < n.length(); i++) {
            if (max < number[i]) {
                max = number[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int answer = minPartitions("32");
        System.out.println(answer);
    }
}
