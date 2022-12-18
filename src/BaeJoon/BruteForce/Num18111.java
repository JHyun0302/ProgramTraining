package BaeJoon.BruteForce;

import java.util.*;
import java.io.*;

public class Num18111 {
    static int field[][];
    static int result[] = new int[2]; // time, height

    static int time = Integer.MAX_VALUE;
    static int height;
    static int block;
    static int row, col, inven;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        inven = Integer.parseInt(st.nextToken());

        field = new int [row][col];
        int max = 0;
        for(int i = 0; i< row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< col; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, field[i][j]);
            }
        }

        brute_force(max);

        System.out.println(time + " " + height);
    }

    static void brute_force(int max) {

        // field 전체를 탐색해서 각 블럭의 갯수를 맞춰보며, 시간을 계산
        // 각 시간의 최소값으로 갱신.
        for(int i=0; i<=max; i++) {
            result = excavation(i);

            if(time > result[0]) {
                time = result[0];
                height = result[1];
            }
            // 시간이 같을 경우, 높이가 더 높은것을 채택한다.
            else if(time == result[0] && height < result[1]) {
                time = result[0];
                height = result[1];
            }

        }
    }

    static int[] excavation(int height) {
        int block = inven;
        int time = 0;

        for(int i = 0; i< row; i++) {
            for(int j = 0; j< col; j++) {
                int value = field[i][j];

                // value기준으로 맞추려고 하는 높이(height)가 더 낮은 경우
                // 즉, 블럭을 깎아야 하는 경우
                if(value == height) {
                    continue;
                }

                if(value > height) {
                    time += (value - height)*2;
                    block += (value - height);
                }
                // value기준으로 맞추려고 하는 높이(height)가 더 높은 경우
                // 즉, 블럭을 쌓아야하는 경우
                else {
                    time += height - value;
                    block -= (height - value);
                }
            }
        }

        // 남은 블럭의 갯수가 0 미만이면 불가능으로 판단. 최고치를 반환.
        if(block < 0) {
            result[0] = 999999999;
            return result;
        }

        result[0] = time;
        result[1] = height;

        return result;
    }
}