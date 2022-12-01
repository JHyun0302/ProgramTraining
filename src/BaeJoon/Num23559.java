package BaeJoon;

import java.util.Scanner;

public class Num23559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // -1 로 초기화
        for(int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(length));
    }
}
