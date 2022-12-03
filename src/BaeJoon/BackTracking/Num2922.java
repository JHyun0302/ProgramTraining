package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2922 {
    public static long backtracking(char[] alphaArr, int depth, int B, int A, int lexist) {
        if (A >= 3 || B >= 3)
            return 0;
        if (depth == alphaArr.length)
            return lexist;
        long result = 0;
        if (alphaArr[depth] == '_') {
            result += backtracking(alphaArr, depth + 1, B + 1, 0, lexist) * 20; // 자음 들어간 경우
            result += backtracking(alphaArr, depth + 1, B + 1, 0, 1); // L 들어간 경우
            result += backtracking(alphaArr, depth + 1, 0, A + 1, lexist) * 5; // 모음 들어간 경우
        } else {
            if (alphaArr[depth] == 'A')
                result += backtracking(alphaArr, depth + 1, 0, A + 1, lexist);
            else {
                if (alphaArr[depth] == 'L') {
                    result += backtracking(alphaArr, depth + 1, B + 1, 0, 1);
                } else {
                    result += backtracking(alphaArr, depth + 1, B + 1, 0, lexist);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String alphabet = st.nextToken();
        char[] alphaArr = alphabet.toCharArray();
        /**
         * 모음은 모두 A로 변경
         * 자음은 모두 B로 변경
         * L과 _는 그대로
         */
        for (int i = 0; i < alphaArr.length; i++) {
            if (alphaArr[i] == 'A' || alphaArr[i] == 'E' || alphaArr[i] == 'I' || alphaArr[i] == 'O' || alphaArr[i] == 'U') {
                alphaArr[i] = 'A';
            } else if (alphaArr[i] != 'L' && alphaArr[i] != '_') {
                alphaArr[i] = 'B';
            }
        }
        long answer = backtracking(alphaArr, 0, 0, 0, 0);
        System.out.println(answer);
    }
}
