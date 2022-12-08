package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num6003 {
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static int length;

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int startIdx, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startIdx; i < length; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            length = Integer.parseInt(st.nextToken());
            if(length == 0){
                break;
            }
            arr = new int[length];
            visit = new boolean[length];
            result = new int[6];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);



        }
        System.out.println(sb);
    }
}
