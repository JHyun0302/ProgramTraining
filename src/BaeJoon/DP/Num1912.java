package BaeJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1912 {
    static int[] arr;
    static Integer[] memo;
    static int max;

    public static int recursive(int num) {
        if (memo[num] == null) {
            memo[num] = Math.max(recursive(num - 1) + arr[num], arr[num]);

            // 해당 dp[N]과 max 중 큰 값으로 max 갱신
            max = Math.max(memo[num], max);
        }

        return memo[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        arr = new int[num];
        memo = new Integer[num];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        memo[0] = arr[0];
        max = arr[0];
        recursive(num - 1);
        System.out.println(max);
    }
}
