package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Num47 {
    static boolean visit[];
    public static List<List<Integer>> permuteUnique(int[] nums) {
        visit = new boolean[nums.length];
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
                if(visit[i] == true && temp.contains(nums[i])) // 다시 생각해!!!
                    continue;
                visit[i] = true;
                temp.add(nums[i]);
                backtracking(list, nums, temp);
                visit[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> list = new ArrayList<>();
        list = permuteUnique(nums);
        System.out.println(list);
    }
}
