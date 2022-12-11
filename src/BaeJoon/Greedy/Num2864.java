package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        String maxA = "";
        String maxB = "";
        String minA = "";
        String minB = "";

        for(int i =0; i<A.length(); i++){
            if(A.charAt(i) == '5' ||A.charAt(i) == '6'){
               maxA += '6';
               minA += '5';
            }
            else {
                maxA += A.charAt(i);
                minA += A.charAt(i);
            }
        }

        for(int i =0; i<B.length(); i++){
            if(B.charAt(i) == '5' || B.charAt(i) == '6'){
                maxB += '6';
                minB += '5';
            }
            else {
                maxB += B.charAt(i);
                minB += B.charAt(i);
            }
        }
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);
        int min = Integer.parseInt(minA) + Integer.parseInt(minB);

        System.out.println(min + " " + max);



    }
}
