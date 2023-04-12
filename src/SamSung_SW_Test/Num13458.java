package SamSung_SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num13458 {
    static int[] eachOfStudent;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int NumOfClass = Integer.parseInt(st.nextToken());
        eachOfStudent = new int[NumOfClass + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < eachOfStudent.length; i++) {
            eachOfStudent[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        func(NumOfClass, b, c);

    }

    private static void func(int numOfClass, int b, int c) {
        for (int i = 0; i < numOfClass; i++) {
            eachOfStudent[i] -= b;
            result++;

            if (eachOfStudent[i] > 0) {
                result += eachOfStudent[i] / c;

                if (eachOfStudent[i] % c > 0) {
                    result++;
                }
            }
        }

        System.out.println("result = " + result);
    }
}
