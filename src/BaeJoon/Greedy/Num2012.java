package BaeJoon.Greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Num2012 {
    static int[] student;
    static int[] rank;

    public static void helper() {
        Arrays.sort(student);
        long discontent = 0;
        for (int i = 0; i < student.length; i++) {
            discontent += Math.abs(rank[i] - student[i]);
        }
        System.out.println(discontent);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        student = new int[num];
        rank = new int[num];

        for (int i = 0; i < num; i++) {
            student[i] = sc.nextInt();
            rank[i] = i + 1;
        }
        helper();

    }

}
