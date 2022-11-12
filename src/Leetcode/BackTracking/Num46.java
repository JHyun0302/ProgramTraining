package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtracking(list, nums, new ArrayList<>());
        return list;
    }

    public static void backtracking(List<List<Integer>> list, int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp)); // [] 추가
        }
        else {
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i])) // skip duplicate
                    continue;
                temp.add(nums[i]);
                backtracking(list, nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        list = permute(nums);
        System.out.println(list);
    }
}
