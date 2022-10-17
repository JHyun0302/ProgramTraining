package Programmers.Graph;

import java.util.Arrays;

public class Target_number{
    int answer = 0;
/*    public int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);
        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int sum){
        if(numbers.length == depth){
            if(target == sum)
                answer++;
        }
        else{
            dfs(numbers, depth+1, target, sum+numbers[depth]);
            dfs(numbers, depth+1, target, sum-numbers[depth]);
        }
    }*/

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int depth, int sum){
        if(numbers.length == depth)
            if(target == sum)
                answer++;
            else{
                dfs(numbers, target, depth-1, sum+numbers[depth]);
                dfs(numbers, target, depth+1, sum-numbers[depth]);
            }
    }
}
