package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2407 {
    private static long n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        long result = 1;
        int temp = 1;
        for (int i = 0; i < m; i++) {
            result *= (n - i);

            temp *= (i + 1);
        }
        System.out.println(result / temp);

    }
}
