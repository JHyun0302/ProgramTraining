package BaeJoon.Fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2747 {

    static int[] dp;
    static int temp;

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (dp[num] != -1) {
            return dp[num];
        } else {
            temp = fibonacci(num - 1) + fibonacci(num - 2);
            dp[num] = temp;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        dp = new int[46];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int ans = fibonacci(num);
        System.out.println(ans);
    }
}
