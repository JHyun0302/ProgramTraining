package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10819 {
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static int num;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int depth) {
        if (depth == num) {
            int sum =0;
            for (int i = 0; i < num - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < num; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        arr = new int[num];
        result = new int[num];
        visit = new boolean[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0);
        System.out.println(max);
    }
}
