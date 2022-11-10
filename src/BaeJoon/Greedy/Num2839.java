package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sugar= Integer.parseInt(st.nextToken());
        int answer = 0;

        while (sugar > 0){
            if(sugar % 5 == 0){
                sugar -=  5;
                answer++;
            }
            else if(sugar % 3 == 0){
                sugar -=  3;
                answer++;
            }

            else if(sugar  > 5){
                sugar -=  5;
                answer++;
            }
            else {
                answer = -1;
                break;
            }

        }

        System.out.println(answer);
    }
}
