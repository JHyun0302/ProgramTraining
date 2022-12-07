package Leetcode.BackTracking;

public class Num1863 {
    static int sum = 0;

    public static int subsetXORSum(int[] nums) {
        dfs(nums, 0, sum);
        return sum;
    }

    public static void dfs(int[] nums, int start, int prevsum) {
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int currSum = prevsum ^ nums[i];
            sum += currSum;
            dfs(nums, i + 1, currSum);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 6};
        System.out.println(subsetXORSum(nums));
    }
}
