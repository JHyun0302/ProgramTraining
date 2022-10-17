package Leetcode;

public class Num997 {
    /*public int findJudge(int n, int[][] trust) {

        int count[] = new int[n+1];

        for(int t[] : trust){
            count[t[0]]--;     // 신뢰 하는 쪽
            count[t[1]]++;   // 신뢰 받는 쪽
        }

        for(int i=1;i<=n;i++){
            if(count[i]==n-1) return i;
        }
        return -1;

    }*/
    static int[][] trust;
    public  static int findJudge(int n, int[][] trust) {
        int i,j;
        int k=0;
        int  cnt =0;
        int[] temp = new int[n];
        for(i =0;i< temp.length;i++)
            temp[i] = i+1;
        for(i =0; i<temp.length; i++) {
            for (j = 0; j < trust.length; j++) {
                if (temp[i] != trust[j][0]) {
                    if (temp[i] == trust[k][1]){
                        cnt++;
                    }
                    else
                        k += 1;
                }
                System.out.println(cnt);
            }
            if(cnt == n-1)
                return temp[i];
            cnt =0;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;

        trust = new int[2][2];
        trust[0][0] = 1;
        trust[0][1] = 3;
        trust[1][0] = 2;
        trust[1][1] = 3;

        int res= findJudge(n, trust);
        System.out.println("res:" + res);
    }
}
