package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num15656 {
    static int arraryNum;
    static int length;
    static int[] arr;

    static int[] temp;

    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int length) {
        if (depth == length) {
            for (int val : temp) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arraryNum; i++) {
            temp[depth] = arr[i];
            dfs(depth + 1, length);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arraryNum = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[arraryNum];
        temp = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, length);
        System.out.println(sb);
    }
}
