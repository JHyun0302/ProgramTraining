package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num15666 {
    static int arraryNum;
    static int length;
    static int[] arr;
    static int[] temp;
    static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int at) {
        if (depth == length) {
            for (int val : temp) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = at; i < arraryNum; i++) {
            if(before != arr[i]){
                temp[depth] = arr[i];
                before = arr[i];
                dfs(depth + 1, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arraryNum = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        arr = new int[arraryNum];
        temp = new int[length];
        visit = new boolean[arraryNum];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }
}
