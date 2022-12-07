package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15652 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];

        perm(arr, M, N, 0, 1);
        System.out.println(sb);
    }

    public static void perm(int[] arr, int M, int N, int depth, int at) {
        if (M == depth) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            perm(arr, M, N, depth + 1, i);
        }
    }

}
