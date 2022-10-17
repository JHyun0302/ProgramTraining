package Middle_Test_Template;

public class Stepping_Stone {
    static int[] dp;

    public static int step_stone(int n, int[] arr){
        int i;
        dp = new int[arr[0]+1];
        int[] cost = new int[arr[0]+1];
        for(i=0;i<arr[0];i++)
            cost[i] = i+1;

        dp[0] = cost[0];
        dp[1] = cost[1];
        for(i = 2; i<arr[0]; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[arr.length-1], dp[arr.length-2]);
    }
    public static void main(String[] args) {
        int i;
        int n = 3;
        int[] arr =new int[n+1];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 6;
        int ans = step_stone(n,arr);

        System.out.println(ans);

    }
}


