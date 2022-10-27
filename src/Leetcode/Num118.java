package Leetcode;
//Pascal's Triangle
import java.util.List;
import java.util.ArrayList;
public class Num118 {
    public List<List<Integer>> generate(int numRows) {
        int i,j;
        int dp[][] = new int[numRows+1][numRows+1];
        dp[0][0] = 1;
        for(i = 1; i<numRows; i++){
            dp[0][i] = 1;
            dp[i][0] = 1;
        }
        for(i = 1; i<numRows; i++){
            for(j=1;j<numRows;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        List<List<Integer>> aList =  new ArrayList<List<Integer>>(numRows);
        int temp = 0;
        for(i =0;i<numRows;i++){
            temp = i;
            List<Integer> a1 = new ArrayList<Integer>();
            for(j =0;j<=i;j++){
                a1.add(dp[temp][j]);
                temp--;
            }
            aList.add(a1);
        }
        return aList;
    }
}
