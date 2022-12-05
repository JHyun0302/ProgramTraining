package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1541 {
    /**
     * '덧셈 부분을 먼저 계산 하는 것'
     * 1. 뺄셈(-)을 기준으로 1차적으로 문자열을 분리해준다.
     * 2. 분리된 문자열들 각각에 포함 된 정수 값들을 모두 더 해준다.
     * 3. 각각 더해진 값들을 뺄셈해준다.
     * <p>
     * 30-70-(20+40)-(10+100+30)-35
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean first = true;
        int sum = Integer.MAX_VALUE;
        String[] subtraction = br.readLine().split("-"); // 30, 70, 20+40, 10+100+30, 35

        for (int i = 0; i < subtraction.length; i++) {
            int temp = 0;
            String[] addition = subtraction[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for (int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }


            if (first == true) { // 처음 들어간 숫자
                sum = temp;
                first = false;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);

    }
}
