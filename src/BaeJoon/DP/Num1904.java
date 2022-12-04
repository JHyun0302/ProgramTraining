package BaeJoon.DP;

import java.util.Scanner;

public class Num1904 {

    /*    static int tile(int length){
            int doubleZeroCount = length / 2;
            int oneCount = 0;
            int calc = 0;
            int sum = 0;
            int oneZero = 0;
            int doubleOneZero = 0;
            for(int i =doubleZeroCount; i>= 0; i--){
                oneCount = length - i * 2; // '00'의 개수에 따른 1의 개수
                oneZero = oneCount;
                doubleOneZero = i;
                if(oneZero == 0){
                    oneZero = 1;
                }
                if(i == 0){
                    doubleOneZero = 1;
                }
                calc = factorial(oneCount + i) / factorial(oneZero) / factorial(doubleOneZero) ;
                sum += calc;
            }
            return sum % 15746;
        }

        public static int factorial (int num) {
            if(num == 0)
                return 0;
            if (num == 1)
                return 1;

            return num * factorial ( num - 1 );
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int length = sc.nextInt();
            int result = tile(length);
            System.out.println(result);
        }*/
    public static int[] dp = new int[1000001];
    ;

    public static int Tile(int length) {

        if (dp[length] == -1) {
            dp[length] = (Tile(length - 1) + Tile((length - 2))) % 15746;
        }
        return dp[length];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // -1 로 초기화
        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(length));
    }
}
