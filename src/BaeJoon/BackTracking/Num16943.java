package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16943 {
    static String strNum;
    static int[] num;
    static int[] temp;
    static boolean[] visit;
    static int standard;
    static int originNum;
    static int max = -1;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == strNum.length()) {
            int tempNum = 0;
            for (int k = 0; k < temp.length; k++) {
                tempNum += temp[k] * Math.pow(10, temp.length - k - 1);
            }
            if (standard > tempNum) {
                max = Math.max(max, tempNum);
            }

            return;
        }
        for (int i = 0; i < strNum.length(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                temp[depth] = num[i];
                if(temp[0] == 0){
                    continue;
                }
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        strNum = st.nextToken();
        standard = Integer.parseInt(st.nextToken());

        visit = new boolean[strNum.length()];
        num = new int[strNum.length()];
        temp = new int[strNum.length()];


        for (int i = 0; i < strNum.length(); i++) {
            num[i] = strNum.charAt(i) - 48;
        }

        for (int i = 0; i < strNum.length(); i++) {
            originNum += (strNum.charAt(i) - 48) * Math.pow(10, strNum.length() - 1 - i);
        }


        dfs(0);

        sb.append(max);
        System.out.println(sb);
    }
}
