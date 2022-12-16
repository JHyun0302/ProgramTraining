package BaeJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11053 {
    static int size;
    static int[] arr;
    static Integer[] dp;
    public static int LTS(int N){
        if (dp[N] == null) {
            dp[N] = 1;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] < arr[N]) {
                dp[N] = Math.max(dp[N], LTS(i) + 1);
            }
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        dp = new Integer[size];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < size; i++) {
            LTS(i);
        }

        int max = dp[0];
        for (int i = 1; i < size; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
