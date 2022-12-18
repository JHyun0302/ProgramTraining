package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num12904 {
    static String longWord;
    static String shortWord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;
        shortWord = br.readLine().toString();
        longWord = br.readLine().toString();

        while (shortWord.equals(longWord) == false){
            if(shortWord.equals(longWord)){
                break;
            }
            if(shortWord.length() > longWord.length()){
                System.out.println(0);
                System.exit(0);
            }
            if(longWord.charAt(longWord.length()-1) == 'A'){ // 맨 끝가지가 A인 경우
                longWord = longWord.substring(0, longWord.length() - 1);
                continue;
            }

            if(longWord.charAt(longWord.length()-1) == 'B'){ // 맨 끝가지가 B인 경우
                longWord = longWord.substring(0, longWord.length() - 1);
                sb = new StringBuffer(longWord);
                longWord = sb.reverse().toString();
            }

        }
        System.out.println(1);

    }
}
