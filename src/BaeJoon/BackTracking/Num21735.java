package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num21735 {
    static int length;
    static int time;
    static int arr[];
    static int initSize = 0; // 눈덩이 처음 크기

    public static void dfs(int depth, int snowSize, int position) {
        if (depth == time || position >= length) {
            initSize = Math.max(initSize, snowSize);
            return;
        }
        dfs(depth + 1, snowSize + arr[position + 1], position + 1);
        dfs(depth + 1, (snowSize / 2) + arr[position + 2], position + 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        arr = new int[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);
        System.out.println(initSize);
    }
}
