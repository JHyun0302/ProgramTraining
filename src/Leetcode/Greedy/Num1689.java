package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.List;

public class Num1689 {
    public static int minPartitions(String n) {
        List<Integer> number = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            number.add(Integer.valueOf(n.charAt(i)));
            if (max < number.get(i)) {
                max = number.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int answer = minPartitions("32");
        System.out.println(answer);
    }
}
