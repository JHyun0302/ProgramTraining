package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int i, j;
        while (testCase > 0) {
            int arrLength = Integer.parseInt(br.readLine());
            int[][] arr = new int[arrLength][2];

            for (i = 0; i < arrLength; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
            int answer = 0;

            int pivot = arr[0][1];
            for (i = 1; i < arrLength; i++) {
                if (arr[i][1] < pivot) {
                    pivot = arr[i][1];
                    answer++;
                }
            }
            System.out.println(answer);

            testCase--;
        }

    }
}
