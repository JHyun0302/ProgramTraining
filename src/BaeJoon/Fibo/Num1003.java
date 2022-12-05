package BaeJoon.Fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1003 {
    /**
     * N에 대한 0호출 횟수 = N-1의 1 호출 횟수
     * N에 대한 1 호출 횟수 = N-1의 0 호출 횟수 + N-1의 1 호출 횟수
     * N 0호출 1호출
     * 0   1   0
     * 1   0   1
     * 2   1   1
     * 3   1   2
     * 4   2   3
     */
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;    // N=0 일 때의 0 호출 횟수
        dp[0][1] = 0;    // N=0 일 때의 1 호출 횟수
        dp[1][0] = 0;    // N=1 일 때의 0 호출 횟수
        dp[1][1] = 1;    // N=1 일 때의 1 호출 횟수

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (testCase > 0) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    public static Integer[] fibonacci(int N) {
        if (dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0]; // 0호출 횟수 계산
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1]; // 1호출 횟수 계산
        }
        return dp[N];
    }

}