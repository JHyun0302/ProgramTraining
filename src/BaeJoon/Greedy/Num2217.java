package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Num2217 {
    /**
     * w = min(내림차순 한 로프 중량) * 사용한 로프 수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRope = Integer.parseInt(br.readLine());

        Integer[] rope = new Integer[numberOfRope];

        for (int i = 0; i < rope.length; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, Collections.reverseOrder());

        int w = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rope.length; i++) {
            w = rope[i] * (i + 1);
            if (max < w) {
                max = w;
            }
        }
        System.out.println(max);
    }
}
