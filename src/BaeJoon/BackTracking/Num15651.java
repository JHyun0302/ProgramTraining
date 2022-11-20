package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15651 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        backtrack(0, arr, N);

        System.out.print(sb);
    }

    public static void backtrack(int depth, int[] arr, int N) {
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            backtrack(depth + 1, arr, N);
        }

    }
}
