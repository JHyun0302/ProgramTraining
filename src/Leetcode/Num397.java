package Leetcode;

public class Num397 {
    /*public static int integerReplacement(long n, int[] memo) {
        return intergerReplace(n, memo);

    }
    public static int intergerReplace(long n, int[] memo) {
        int result;
        if(memo[(int) n] != -1)
            return  memo[(int) n];
        if (n <= 1) {
            return 0;
        }
        if(n % 2 == 0) {
            result = intergerReplace(n/2, memo) +1 ;
            memo[(int)n] = result;
        }
        else {
            result = Math.min(intergerReplace(n-1, memo), intergerReplace(n+1, memo)) + 1;
            memo[(int)n] = result;
        }
        return result;
    }*/
    static int temp =0;
    static int memo[];
    public static int integerReplacement(long n) {
        if(memo[(int)n] != 0)
            return memo[(int)n];
        if(n <= 1)
            return 0;
        if(n % 2 == 0){
            temp = 1+ integerReplacement(n/2);
            memo[(int)n] = temp;
        }
        else{
            temp = Math.min(integerReplacement(n+1), integerReplacement(n-1)) +1;
            memo[(int)n] = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        long n = 4;
        memo = new int[(int)n+1];
        for(int i =0; i<n+1; i++){
            memo[i] = 0;
        }
        System.out.println("n: " + n);
        System.out.println(integerReplacement(n));
    }
}


