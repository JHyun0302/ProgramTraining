package Middle_Test_Template;

import javax.swing.text.Style;

public class Maximum_Profit {
    static int m;
    static int n;
    static int max;
    public static void main(String[] args) {
        int i,j;
        int[][] grid = {
                {3, 5, 3, 2, 4, 5, 3, 2, 0, 7,},
                {9 , 7, 5, 2, 4, 7, 0, 1, 3, 4},
                {1 ,4 ,3, 9, 5, 6, 3, 3, 2, 4 },
                {4, 3 ,2, 1, 4, 7 ,5, 3, 5, 2},
                {2, 3, 5 ,6, 2, 1 ,5 ,8, 0 ,7},
                {8 ,3, 0, 2, 9, 3, 5, 1, 3 ,4},
                {0, 3, 4 ,5 ,2, 1, 4 ,6 ,3 ,1},
                {5, 3 ,2 ,3 ,4, 5, 6, 7 ,9 ,3},
                {2, 4, 6 ,3, 1, 2, 0, 4 ,2 ,8},
                {7 ,3 ,4,2, 9, 4, 3 ,1 ,1 ,2}
        };
        max = Integer.MIN_VALUE;
        m = grid.length;
        n = grid[0].length;
        int cur =0;

        cur += dfs(grid, 0, 0);

        System.out.println("Maximum_Profit: " + cur);
    }

    public static int dfs(int[][] grid, int i, int j){
        if(i<0 || i >= m || j <0 || j>= n)
            return 0;
        else{
            int temp = grid[i][j];
            if(dfs(grid, i+1, j) > dfs(grid, i,j+1))
                return temp + dfs(grid, i+1, j);
            else
                return temp + dfs(grid, i,j+1);
        }
        /*if(grid[i][j] > -1){
            max = Math.max(dfs(grid, i+1, j),dfs(grid, i,j+1));
        }
        return max;*/
    }
}
