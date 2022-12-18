package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10971 {
    static int length;
    static int[][] arr;
    static boolean[] visit;
    static long result_min = Integer.MAX_VALUE;

    public static void dfs(int start, int now, long cost) {
        if (allVisited()) {
            if (arr[now][start] != 0) {
                result_min = Math.min(result_min, cost + arr[now][0]);
            }
            return;
        }
        for (int i = 1; i < length; i++) {
            if (visit[i] == false && arr[now][i] != 0) {
                visit[i] = true;
                dfs(start, i, cost + arr[now][i]);
                visit[i] = false;
            }
        }
    }
    public static boolean allVisited(){
        for(int i = 0; i<length; i++){
            if(visit[i] == false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        arr = new int[length][length];


        for(int i = 0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<length; i++){
            visit = new boolean[length];
            visit[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(result_min);
    }
}
