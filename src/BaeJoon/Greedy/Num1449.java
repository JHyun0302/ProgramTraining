package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Num1449 {

    static int hole;
    static int tapeLength;
    static int[] position;
    static int cnt =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        hole = Integer.parseInt(st.nextToken());
        tapeLength = Integer.parseInt(st.nextToken());
        position = new int[hole];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<position.length; i++){
            position[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(position);
        double left = position[0] - 0.5;
        cnt = 1;

        for(int i=0; i<hole; i++) {
            if(left+tapeLength < position[i]) { //동 떨어진 위치
                cnt++;
                left = position[i] - 0.5; // left 갱신
            }
        }
        System.out.println(cnt);
    }
}
