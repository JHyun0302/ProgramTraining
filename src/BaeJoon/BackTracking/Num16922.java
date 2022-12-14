package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num16922 {
    static int num = 0;
    static int[] arr = {1,5,10,50};
    static boolean[] visit = new boolean[10001];
    static int answer=0;
    public static void dfs(int depth, int sum){
        if(depth == num){
            if(visit[sum] == false){
                answer++;
                visit[sum] = true;
            }
            return;
        }
        for(int i =0; i< arr.length; i++){
            dfs(depth+1, sum + arr[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        dfs(0, 0);
        System.out.println(answer);
    }
}

