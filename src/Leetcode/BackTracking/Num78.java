package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        list = subsets(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, nums, new ArrayList<>(), 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, int[] nums, List<Integer> temp, int idx) {
        list.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(list, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
/*    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        list = subsets(nums);
        System.out.println(list);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(list, nums, temp, 0);
        return list;
    }
    public static void backtracking(List<List<Integer>> list, int[] nums, List<Integer> temp, int idx){
        if( nums.length== idx){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backtracking(list, nums, temp, idx+1);
        temp.remove(temp.size()-1);
        backtracking(list, nums, temp, idx+1);
    }*/

}
