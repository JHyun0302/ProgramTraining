package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1932 {
    public static void main(String[] args) throws IOException {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int diff = 0; //며칠 차이

        for (int i = 1; i < x; i++) {
            diff += months[i];
        }
        diff += y - 1; //현재 날짜

        String result = days[diff % 7];
        System.out.println(result);

    }
}
