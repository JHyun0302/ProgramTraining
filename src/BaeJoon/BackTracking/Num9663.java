package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num9663 {
    static int N;
    static boolean[][] arr;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new boolean[N][N];

        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int depth){
        if(depth == N){
            answer++;
            return;
        }

        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++){
                if(arr[i][j] == false){
                    arr[0][j] = true;
                    arr[j][0] = true;
                    arr[j][j] = true;
                }
                dfs(depth+1);
            }

        }
    }
}
