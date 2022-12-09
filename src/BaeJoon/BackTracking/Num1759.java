package BaeJoon.BackTracking;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Num1759 {
    static int cryptoLength;
    static int arrLength;
    static char[] arr;
    static char[] temp;

    static boolean[] visit;

    public static void dfs(int depth, int at) {
        if (depth == cryptoLength) {
            StringBuilder sb = new StringBuilder();
            int v = 0;
            int cc = 0;

            for (int i = 0; i < arrLength; i++) {
                if (visit[i]) {
                    sb.append(temp[i]);

                    if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
                        v++; //자음
                    } else {
                        cc++; //모음
                    }
                }
            }
            if (v >= 1 && cc >= 2)
                System.out.println(sb);
        }

        for (int i = at; i < arrLength; i++) {
            visit[i] = true;
            dfs(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        cryptoLength = sc.nextInt();
        arrLength = sc.nextInt();

        arr = new char[arrLength];
        temp = new char[arrLength];
        visit = new boolean[arrLength];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = sc.next().charAt(0);
        }
        Arrays.sort(temp); // a c i s t w

        dfs(0, 0);
    }
}
