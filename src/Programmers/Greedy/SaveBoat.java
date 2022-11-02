package Programmers.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class SaveBoat {
    public int solution(int[] people, int limit) {
        int i,j;
        int l = 0;
        int r = people.length-1;
        int answer =0;
        Arrays.sort(people);
        while(l<r){
            int sum = people[l] + people[r];
            if(sum > limit){
                r--;
                answer++;
            }
            else{
                l++;
                r--;
                answer++;
            }
        }
        if(r == l)
            answer ++;
        return answer;
    }
}
