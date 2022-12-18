package BaeJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subject = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> score = new ArrayList<>();
        float[] newScore = new float[subject];
        float max = Integer.MIN_VALUE;
        float sum = 0;
        for (int i = 0; i < subject; i++) {
            newScore[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, newScore[i]);

            sum += newScore[i];
        }

        float result = sum * 100 / max / subject;

        System.out.println(result);
    }
}
