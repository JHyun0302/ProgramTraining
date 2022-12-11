package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num1026 {

    static int arrLength;
    static int[] A;
    static Integer[] B;

    public static void calc(){
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int answer = 0;
        for(int i =0; i<arrLength; i++){
            answer += A[i] * B[i];
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrLength = Integer.parseInt(st.nextToken());
        A = new int[arrLength];
        B = new Integer[arrLength];
        int i;
        st = new StringTokenizer(br.readLine());
        for(i =0; i<arrLength; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(i =0; i<arrLength; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        calc();
    }
}
