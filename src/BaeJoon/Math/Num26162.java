package BaeJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num26162 {
    static int[] arr;
    public static int isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return n;
            }
        }
        return 1;
    }
    public static void check(int num){
        int i =0;
        boolean checker = false;
        while (num > 0){
            checker = false;
            if(arr[i] == 2){
                System.out.println("No");
                checker = true;
            }
            for(int j =2; j<arr[i]; j++){
                if(arr[i] == isPrime(j) + isPrime(arr[i] - isPrime(j))){
                    System.out.println("Yes");
                    checker = true;
                    break;
                }
            }
            if(checker == false){
                System.out.println("No");
            }
            i++;
            num--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        arr = new int[num];

        for(int i =0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        check(num);
    }
}
