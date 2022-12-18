package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1213 {
    /**
     * case1: 총 개수가 홀수일 때
     * 알파벳 1개 짜리가 2개 이상이면 sorry
     *
     * case2: 총 개수가 짝수일 때
     * 알파벳 1개 짜리가 존재하면 sorry
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int[] alphabet = new int[26];
        for(int i =0; i<name.length(); i++){
            int idx = name.charAt(i) - 'A';
            alphabet[idx]++;
        }

        int odd = 0;
        for(int i =0; i<alphabet.length; i++){
            if(alphabet[i] % 2 == 1)
                odd++;
        }
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(odd > 1)
            answer += "I'm Sorry Hansoo";
        else {
            for(int i =0; i<alphabet.length; i++){
                for(int j =0; j<alphabet[i]/2; j++){
                    sb.append((char) (i + 65));
                }
            }
            answer += sb.toString();
            String end = sb.reverse().toString(); //앞에 넣은 단어 뒤집기

            sb = new StringBuilder();
            for(int i = 0; i<alphabet.length; i++){
                if(alphabet[i] % 2 == 1){ // 홀수찾아서 중간에 삽입
                    sb.append((char) (i + 65));
                }
            }
            answer += sb.toString() + end; //이어붙이기
        }
        System.out.println(answer);

    }
}
