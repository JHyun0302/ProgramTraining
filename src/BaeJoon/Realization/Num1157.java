package BaeJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Num1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        int[] alphabet = new int[26];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(str.charAt(i) == (char)(65 + j)){
                    alphabet[j]++;
                }
            }
        }

        char answer = '?';
        for (int i = 0; i < alphabet.length; i++) {
            if(max < alphabet[i]){
                max = alphabet[i];
                answer = (char) (65 + i);
            } else if (max == alphabet[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
