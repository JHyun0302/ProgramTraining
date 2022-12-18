package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken());
        int[] coin = {500, 100, 50, 10, 5, 1};
        int payback = 1000 - money;
        int answer  =0;

        for(int i =0; i<6; i++){
            if(payback/coin[i] >0){
                answer += payback/coin[i];
                payback %= coin[i];
            }
        }
        System.out.println(answer);
    }
}
