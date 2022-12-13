package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num18429 {
    static int day;
    static int reduceWeight;
    static int target = 500;
    static int[] days;
    static boolean[] visit;
    static int answer=0;
    public static void dfs(int depth, int target){
        if(depth == day){
            answer++;
            return;
        }
        for(int i = 0; i< day; i++){
            if(visit[i] == false && target - reduceWeight + days[i] >= 500){
                visit[i] = true;
                dfs(depth+1, target - reduceWeight + days[i]);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        day = Integer.parseInt(st.nextToken());
        reduceWeight = Integer.parseInt(st.nextToken());
        days = new int[day];
        visit = new boolean[day];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i< days.length; i++){
            days[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        System.out.println(answer);
    }
}
