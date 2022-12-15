package BaeJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2992 {
    static String num;
    static int[] arr;
    static int[] temp;
    static boolean[] visit;
    static int strLength;
    static int min = Integer.MAX_VALUE;
    public static void dfs(int depth){
        if(depth == strLength){
            int newNum = 0;
            int tempLength =strLength;
            for (int k = 0; k < temp.length; k++) {
                newNum += temp[k] * Math.pow(10, tempLength-1);
                tempLength--;
            }
            if(Integer.parseInt(num) < newNum){
                min = Math.min(min, newNum);
            }
            return;
        }

        for (int i = 0; i < strLength; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine();
        strLength = num.length();
        arr = new int[strLength];
        visit = new boolean[strLength];
        temp = new int[strLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - 48;
        }
        dfs(0);
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        System.out.println(min);
    }
}
