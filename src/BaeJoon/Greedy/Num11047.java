package BaeJoon.Greedy;

import java.io.IOException;
import java.util.Scanner;

public class Num11047 {

    public static void helper(int numberOfCoin, int money){
        int ret = 0;

        for(int i = numberOfCoin -1; i >= 0; i--){
            if(arr[i] <= money){
                ret += (money / arr[i]);
                money = money % arr[i];
            }
        }
        System.out.println(ret);
    }
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfCoin = sc.nextInt();
        int money = sc.nextInt();
        arr = new Integer[numberOfCoin];

        for(int i =0; i< numberOfCoin; i++){
            arr[i] = sc.nextInt();
        }

        helper(numberOfCoin, money);
    }
}
