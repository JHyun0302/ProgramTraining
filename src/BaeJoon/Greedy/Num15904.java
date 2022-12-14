package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");
        int i = 0;

        for (String check : input) {
            if (i == 0 && check.equals("U")) {
                i++;
            }
            if ((i == 1 || i == 3) && check.equals("C")) {
                i++;
            }
            if (i == 2 && check.equals("P")) {
                i++;
            }

        }
        if (i == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }
}
