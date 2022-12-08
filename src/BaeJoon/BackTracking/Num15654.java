package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Num15654 {
    static int arraryNum;    // 정적변수로 변경
    static int length;    // 정적변수로 변경
    static int[] arr;
    static boolean[] visit;

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
            if (visit[i] == false) {
                visit[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, length);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정적변수 N과 M을 초기화해준다.
        arraryNum = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[arraryNum];
        visit = new boolean[arraryNum];
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
