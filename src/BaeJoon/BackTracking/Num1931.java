package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num1931 {
    static int numberOfMeet;
    static int[][] meet;
    static int cnt =1; // meet[0][0]부터 시작

    static int startTime = Integer.MIN_VALUE;

    static int endTime;

    public static void calc(){
        for(int i =1; i< numberOfMeet; i++){
            startTime = meet[i][0];
            if(endTime <= startTime){
                endTime = meet[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfMeet = Integer.parseInt(st.nextToken());
        meet = new int[numberOfMeet][2];
        int i;
        for(i =0; i < numberOfMeet; i++){
            st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meet, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        endTime = meet[0][1];

        calc();
    }
}
