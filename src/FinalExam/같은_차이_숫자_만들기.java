package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 같은_차이_숫자_만들기 {
    public static StringBuilder sb = new StringBuilder();
    static int numberOfDigits;

    static int[] num;

    static List<String> list = new ArrayList<>();
    static int diff;

    /**
     * Brute Force
     */
/*    public static void calc() {
        for (int i = (int) Math.pow(10, numberOfDigits - 1); i < (int) Math.pow(10, numberOfDigits); i++) {
            int cnt = 0;
            int temp = i;
            for (int j = 0; j < numberOfDigits; j++) {
                num[j] = (int) (temp / Math.pow(10, numberOfDigits - 1 - j));
                temp = (int) (i % Math.pow(10, numberOfDigits - 1 - j));
            }
            for (int k = 0; k < numberOfDigits - 1; k++) {
                if (diff == Math.abs(num[k] - num[k + 1])) {
                    cnt++;
                }
                if (cnt + 1 == numberOfDigits) {
                    System.out.print(i + " ");
                }
            }

        }
        System.out.println();
    }*/

    /**
     * Greedy
     */
    public static void calc() {
        int cnt = 0;
        int eachcount = numberOfDigits / 2; // ABAB, ABA, ABABAB, AB, A...(A와 B의 개수)
        for (int i = 1; i <= 9; i++) { //최대 자리 숫자, 100...
            for (int j = 0; j <= 9; j++) {
                if (Math.abs(i - j) == diff) {
                    list.add(String.valueOf(i));
                    list.add(String.valueOf(j));

                    for (int k = 0; k < eachcount; k++) {
                        sb.append(list.get(0) + list.get(1));
                    }
                    if (numberOfDigits % 2 == 1) {
                        sb.append(list.get(0));
                    }
                    sb.append(" ");
                    list.clear();
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            numberOfDigits = Integer.parseInt(st.nextToken());
            num = new int[numberOfDigits];
            diff = Integer.parseInt(st.nextToken());

            calc();
            sb.append("\n");
            testCase--;
        }
        System.out.println(sb);
    }
}

/**
 * 2
 * 3 7
 * 2 1
 */