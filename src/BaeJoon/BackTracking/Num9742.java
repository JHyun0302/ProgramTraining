package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num9742 {
    static String input;
    static int inputLength;
    static String[] arr;
    static String[] temp;
    static boolean[] visit;
    static int order;
    static int cnt =1;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == inputLength) {
            if(cnt == order){
                for (String val : temp) {
                    sb.append(val);
                }
            }
            cnt++;
            return;
        }
        for (int i = 0; i < inputLength; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.nextToken()!=null) {
            input = st.nextToken();
            order = Integer.parseInt(st.nextToken());

            inputLength = input.length();
            arr = new String[inputLength];
            temp = new String[inputLength];
            visit = new boolean[inputLength];
            for (int i = 0; i < inputLength; i++) {
                arr[i] = String.valueOf(input.charAt(i));
                temp[i] = String.valueOf(input.charAt(i));
            }
            sb.append(input + " " + order + " " + '=' + " ");
            dfs(0);
        }
        if (sb.length() == (input.length() + String.valueOf(order).length() + 4)) {
            sb.append("No permutation");
        }
        System.out.println(sb);
    }
}
