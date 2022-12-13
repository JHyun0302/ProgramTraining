package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long small = Long.parseLong(st.nextToken());
        long big = Long.parseLong(st.nextToken());
        int cnt = 1;
        while (small != big){
            if(big < small){
                System.out.println(-1);
                System.exit(0);
            }

            if(big % 2 == 0){
                big /= 2;
            }

            else if(big % 10 == 1){
                big /= 10;
            }
            else{
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
