package Leetcode;

public class Num997 {
    public int findJudge(int n, int[][] trust) {

        int count[] = new int[n+1];

        for(int t[] : trust){
            count[t[0]]--;     // 신뢰 하는 쪽
            count[t[1]]++;   // 신뢰 받는 쪽
        }

        for(int i=1;i<=n;i++){
            if(count[i]==n-1) return i;
        }
        return -1;

    }
}
