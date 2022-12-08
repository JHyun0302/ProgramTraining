package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잔돈_바꿔주기 {
    static int testCase;
    static int customer;

    static int[] arr;

    static int[] wallet;

    /**
     * wallet[1] = 5
     * wallet[2] = 10
     * wallet[3] = 15
     * wallet[4] = 20
     * wallet[5] = 25
     * ...
     */

    public static void calc() {
        wallet = new int[1001]; // wallet 크기는 max
        int fiveCent = 1;
        if (arr[0] < 5) {
            System.out.println("False");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 5) {
                    wallet[1] += fiveCent;
                } else {
                    wallet[arr[i] / 5] += 1;
                    wallet[1] -= fiveCent;
                }
                if (wallet[1] < 0) {
                    System.out.println("False");
                    return;
                }
            }
            System.out.println("True");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());

        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            customer = Integer.parseInt(st.nextToken());
            arr = new int[customer];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            calc();

            testCase--;
        }
    }
}
/**
 * 2
 * 5 5 5 5 10 20
 * 5 5 5 10 10 20
 */