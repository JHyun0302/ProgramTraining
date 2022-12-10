package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // P일 중
            int L = Integer.parseInt(st.nextToken()); // L일 동안 사용 가능
            int V = Integer.parseInt(st.nextToken()); // V일짜리 휴가

            if (P == 0 & L == 0 & V == 0) {
                break;
            }
            int total = P * (V / L) + Math.min(P, V % L);

            sb.append("Case " + cnt + ": " + total + "\n");
            cnt++;
        }
        System.out.print(sb);
    }
}
