package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14888 {
    static int[] arr;
    static int[] calc = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void backtrack(int num, int idx) {
        if (idx == arr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        /**
         * 연산자 다쓰면 다음 연산자 사용함.(+ - * /)
         */
        for (int i = 0; i < 4; i++) {
            if (calc[i] > 0) {
                calc[i]--;

                switch (i) {
                    case 0:
                        backtrack(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        backtrack(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        backtrack(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        backtrack(num / arr[idx], idx + 1);
                        break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                calc[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < calc.length; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
}
