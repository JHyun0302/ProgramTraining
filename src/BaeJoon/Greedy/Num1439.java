package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringTokenizer zero = new StringTokenizer(S, "0");
        StringTokenizer one = new StringTokenizer(S, "1");

        System.out.println(Math.min(zero.countTokens(), one.countTokens()));
    }
}
