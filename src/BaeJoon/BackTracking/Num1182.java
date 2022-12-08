package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1182 {
    static int arraryNum;
    static int target;
    static int[] arr;
    static int[] result;
    static int cnt =0;
    static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int sum) {
        if (depth == arraryNum) {
            if(sum == target){
                cnt++;
            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arraryNum = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[arraryNum];
        result = new int[arraryNum];
        visit = new boolean[arraryNum];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (target == 0) System.out.println(cnt - 1);
            //S 0일때가 전체 합이 0 일때랑 겹치기 때문에 -1 을 해주어야 합니다.
            //위의 사진에 공집합이 0이라고 볼 수 있습니다
        else  System.out.println(cnt);
    }
}
