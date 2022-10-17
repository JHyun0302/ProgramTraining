package Middle_Test_Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pascal_Triangle {
    static int[][] dp;

    public static int[][] pascal_triangle(int n){
        int i,j;
        int res[][] = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        dp[0][0] = 1;
        for(i = 1;i<=n; i++){
            dp[i][0] = 1;
            dp[0][i] = 1;
        }

        for(i = 1;i<n; i++){
            for(j =1; j<n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        int temp =0;
            for(i =0; i<n;i++){
                temp = i;
                for(j =0; j<=i;j++){
                    res[i][j] = dp[temp][j];
                    temp--;
                }
            }
        return res;
    }
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[][] ans;
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();*/
        int i,j;
        int n = 5;
        int[] arr = new int[n];
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 1;
        int[][] ans = pascal_triangle(n);


        for(int k: arr){
            for( j =0; j< k; j++){
                System.out.print(ans[k-1][j]);
            }
            System.out.println();
        }






    }
}
