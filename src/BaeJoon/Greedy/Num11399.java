package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken()); //사람수
        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine());
        int i, j;
        for (i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int cnt = 5;
        int prev = 0;
        Arrays.sort(arr);
        for (i = 0; i < count; i++) {
            answer += prev + arr[i];
            prev += arr[i];
        }
        System.out.println(answer);

    }
}


