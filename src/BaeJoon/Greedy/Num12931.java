package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrLength = Integer.parseInt(st.nextToken());
        int[] B = new int[arrLength];
        st = new StringTokenizer(br.readLine());

        int i;
        int answer = 0;
        int sum = 0;
        for (i = 0; i < arrLength; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sum += B[i];
        }


        while (sum != 0) {
            int cnt = 0;
            for (i = 0; i < arrLength; i++) {
                if (B[i] % 2 == 1) { // 홀수 경우
                    B[i]--;
                    cnt++;
                }
            }

            if (cnt > 0) {
                sum -= cnt;
                answer += cnt;
            } else { // 모두 짝수인 경우
                for (i = 0; i < arrLength; i++) {
                    B[i] /= 2;
                }
                sum /= 2;
                answer++;
            }
        }
        System.out.println(answer);

    }

}
