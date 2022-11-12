package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num39 {
/*    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, 0);
        return list;
    }
    public void backtracking(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start){
        list.add(temp);
        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtracking(list, temp, candidates, start+1);
            temp.remove(temp.size()-1);
        }
    }*/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                temp.add(candidates[i]);
                backtracking(list, temp, candidates, remain - candidates[i],i); // not i + 1 because we can reuse same elements
                temp.remove(temp.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] candidates = {2,3,6,7};
        int target = 7;
        list = combinationSum(candidates, target);
        System.out.println(list);
    }

}
