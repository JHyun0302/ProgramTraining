package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보물_나누어_갖기 {
    static int testCase;
    static int theif;
    static int numberOfTreasure;
    static int[] treasure;

    public static void calc() {
        int sum = 0;
        for (int i = 0; i < treasure.length; i++) {
            sum += treasure[i];
        }
        if (sum % theif == 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());

        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            theif = Integer.parseInt(st.nextToken());
            numberOfTreasure = Integer.parseInt(st.nextToken());
            treasure = new int[numberOfTreasure];

            for (int i = 0; i < treasure.length; i++) {
                treasure[i] = Integer.parseInt(st.nextToken());
            }
            calc();

            testCase--;
        }
    }
}

/**
 * 2
 * 4 7 4 3 2 3 5 2 1
 * 3 4 1 2 3 4
 */