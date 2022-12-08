package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10974 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;

    public static void dfs(int depth, int num){
        if(depth == num){
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<num; i++){
            if(visit[i] == false){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1, num);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        arr = new int[num];
        visit = new boolean[arr.length];

        dfs(0, num);
        System.out.println(sb);
    }

}
