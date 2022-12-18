package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2961 {
    static int number;
    static int[] sour;
    static int[] bitter;
    static int compare = Integer.MAX_VALUE;
    public static void dfs(int depth, int input, int sourTaste, int bitterTaste) {
        /**
         * 조건1: sour값끼리 곱 & bitter값끼리 합의 차이가 최소화
         * 조건2: 1개 배열에서 특정 idx 사용시 다른 한 쪽에서도 사용하기
         */
        if(depth == number){
            if(input != 0){
                compare = Math.min(compare, Math.abs(sourTaste - bitterTaste));
            }
            return;
        }

        dfs(depth+1, input, sourTaste, bitterTaste);
        dfs(depth+1, input+1, sourTaste * sour[depth], bitterTaste + bitter[depth]);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        number = Integer.parseInt(br.readLine());
        sour = new int[number];
        bitter = new int[number];

        for (int i = 0; i < number; i ++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0,1, 0);
        System.out.println(compare);
    }
}
