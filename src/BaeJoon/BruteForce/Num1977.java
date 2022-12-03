package BaeJoon.BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num1977 {
    public static List<Integer> calc(int m, int n) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> Return = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if ((long) Math.sqrt(i) * (long) Math.sqrt(i) == i) {
                sum += i;
                if (min > i) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            Return.add(-1);
            return Return;
        }
        Return.add(sum);
        Return.add(min);
        return Return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> ret = calc(M, N);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }

    }
}
