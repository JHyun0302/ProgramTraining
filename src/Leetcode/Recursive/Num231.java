package Leetcode.Recursive;

public class Num231 {
    public static boolean isPowerOfTwo(int n) {
/*        if(n == 1)
            return true;
        else if (n == 0)
            return false;
        else if (n%2 == 0)
            return isPowerOfTwo(n/2);
        else
            return false;*/
        if(n == 1)
            return true;
        else if(n ==0)
            return false;
        else if (n % 2 == 0)
            return isPowerOfTwo(n/2);
        else
            return false;

    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
}
