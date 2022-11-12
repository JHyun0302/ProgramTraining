package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num40 {
/*    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    public static void backtracking(List<List<Integer>> list, List<Integer> temp, int[] candidates,int remain, int start){
        if(remain <0)
            return;
        else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) // skip duplicates
                    continue;
                temp.add(candidates[i]);
                backtracking(list, temp, candidates, remain - candidates[i],i+1); // not i + 1 because we can reuse same elements
                temp.remove(temp.size()-1);
            }
        }

    }*/

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    public static void backtracking(List<List<Integer>> list, List<Integer> temp, int[] candidates,int remain, int start){
        if(remain <0)
            return;
        else if (remain == 0) {
            if(!list.contains(new ArrayList<>(temp))) // skip duplicate
                list.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                backtracking(list, temp, candidates, remain - candidates[i],i+1);
                temp.remove(temp.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        list = combinationSum2(candidates, target);
        System.out.println(list);
    }

}
