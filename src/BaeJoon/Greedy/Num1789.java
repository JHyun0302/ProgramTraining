package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long input = Long.parseLong(st.nextToken());
        long sum = 0;
        int i = 0;
        while (input >= sum){
            sum += ++i;
        }
        if(sum == input){
            System.out.println(i);
        }
        else{
            System.out.println(i-1);
        }
    }
}
