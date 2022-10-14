package Leetcode;

public class Num778 {
    int visited[][];
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        int low = grid[0][0];
        int high = len*len -1;
        visited = new int[len+1][len+1];
        int max = 0;
        while (low < high){
            int mid = (low+high)/2;
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i < 0 || i >= grid.length || j < 0 || j >= grid.length)
                    continue;
                int curretArea = dfs(grid, 0, 0);
                max = Math.max(max, curretArea);
            }
        }
            return max;
        }
        int cnt = 0;
        int min =0;
        public int dfs(int[][] grid, int i, int j){
            if (visited[i][j] == 0){
                visited[i][j] = 1;

                min = Math.min(Math.min(Math.min(grid[i][j-1], grid[i][j+1]), grid[i+1][j]), grid[i-1][j]);

                cnt+=dfs(grid, i, j+1);
                cnt+=dfs(grid, i, j-1);
                cnt+=dfs(grid, i+1, j);
                cnt+=dfs(grid, i-1, j);

            }
        return cnt;
    }
}
