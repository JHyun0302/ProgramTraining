package Leetcode.Greedy;

import java.util.Arrays;
import java.util.Collection;

public class Num1877 {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        int[] pairSum = new int[mid];
        for (int i =0; i< mid; i++){
            pairSum[i] = nums[i] + nums[nums.length-i-1];
        }
        int max = Integer.MIN_VALUE;
        for (int pair : pairSum) {
            if(max < pair){
                max = pair;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 3};
        System.out.println(minPairSum(nums));
    }
}
