package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num19949 {
    static int[] correct;

    static int[] choice;
    static boolean[] visit;
    static int count =0;

    public static void dfs(int depth){
        /**
         * 조건1: 같은 답 3연속 찍기 불가능
         * 조건2: 총점이 5점 이상일 때 count+1
         */
        if(depth == 10){
            int sum =0;
            for(int i =0; i<10; i++){
                if(correct[i] == choice[i]){
                    sum++; // 점수
                }
            }
            if(sum >= 5){
                count++; // 경우의 수(정답)
            }
            return;
        }
        for(int i =1; i<6; i++){
            if(depth > 1 && choice[depth-1] == i && choice[depth-2] == i){ //3연속 같은 답인 경우 continue;
                continue;
            }
            choice[depth] = i; // 1~5번 중 선택
            dfs(depth + 1);
            choice[depth] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        correct = new int[10];
        choice = new int[10];
        visit = new boolean[10];
        for(int i =0; i< correct.length; i++){
            correct[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(count);
    }
}
