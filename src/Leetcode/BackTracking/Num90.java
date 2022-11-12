package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, nums, new ArrayList<>(), 0);
        return list;
    }

    public static void backtracking(List<List<Integer>> list, int[] nums, List<Integer> temp, int idx){
        list.add(new ArrayList<>(temp)); // [] 추가
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) // skip duplicates
                continue;
            temp.add(nums[i]);
            backtracking(list, nums, temp, i+1);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> list = new ArrayList<>();
        list = subsetsWithDup(nums);
        System.out.println(list);
    }
}
