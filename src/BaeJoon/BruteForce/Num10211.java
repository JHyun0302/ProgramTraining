package BaeJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10211 {
    static int length;
    static int[] arr;
    static int[] dp = new int[1001];

    public static void calcSubarray() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];
            if (arr[i] + dp[i - 1] > arr[i]) {
                dp[i] = arr[i] + dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            length = Integer.parseInt(br.readLine());
            arr = new int[length + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            calcSubarray();
        }
    }
}
