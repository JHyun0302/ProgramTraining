package Leetcode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num2160 {
    public static int minimumSum(int num) {
        List<Integer> number = new ArrayList<>();
        while (num > 0) {
            number.add(num % 10);
            num /= 10;
        }
        Collections.sort(number);
        int new1 = number.get(0) * 10 + number.get(2);
        int new2 = number.get(1) * 10 + number.get(3);
        return new1 + new2;
    }

    public static void main(String[] args) {
        int result = minimumSum(2932);
        System.out.println(result);
    }
}
