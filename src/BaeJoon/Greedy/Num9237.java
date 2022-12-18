package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num9237 {
    static int numberOfTree;
    static Integer[] day;

    static int countDay = 2; // 처음 산 날 + 이장님 초대하는 날

    static int res =0;

    public static void calc(){
        for(int i =0; i<day.length; i++){
            res = Math.max(res, countDay + day[i]);
            countDay++;
        }
        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfTree = Integer.parseInt(st.nextToken());
        day = new Integer[numberOfTree];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i< day.length; i++){
            day[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(day, Collections.reverseOrder());

        calc();
    }
}
