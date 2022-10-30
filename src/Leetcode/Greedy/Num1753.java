package Leetcode.Greedy;

public class Num1753 {
    public int maximumScore(int a, int b, int c) {
        int max = Math.max(c, Math.max(a,b));
        int val1, val2;
        if(max == a){
            val1 = b;
            val2 = c;
        }
        else if(max == b){
            val1 = a;
            val2 = c;
        }
        else{
            val1 = a;
            val2 = b;
        }

        if(max == val1 + val2)
            return max;
        else if(max > val1 + val2)
            return val1+val2;
        else{
            if((val1 + val2) - max > 1)
                return (val1 + val2 - max) /2 + max;
            else
                return max;
        }
    }
}
