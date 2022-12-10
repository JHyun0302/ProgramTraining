package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
     * backtracking
     */

    static int compare =0;
    public static void dfs(int depth) {
        if(depth == numberOfDigits){
            if(num[0] == 0){
                return;
            }
            compare =0;
            for(int i =0; i<num.length-1; i++){
                if(Math.abs(num[i] - num[i+1])== diff){
                    compare += 1;
                }
            }
            if(compare +1 == numberOfDigits){
                for (int i : num) {
                    sb.append(i);
                }
                sb.append(" ");
            }
            return;
        }
        for(int i=0; i<10; i++){
            num[depth] = i;
            dfs(depth+1);
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

            dfs(0);
            System.out.println(sb);

            testCase--;
        }

    }
}

/**
 * 2
 * 3 7
 * 2 1
 */