package Leetcode.Ramdomized;

import java.util.Random;

public class Num398 {
    int[] nums;
    Random rand;

    public Num398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        rand = new Random();
        while (true) {
            int r = rand.nextInt(nums.length); // 0~ num길이 미만의 난수 생성
            if (nums[r] == target) {
                return r;
            }

        }
    }
}
