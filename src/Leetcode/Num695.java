package Leetcode;

public class Num695 {
    int m = 0;
    int n = 0;
    int visited[][];
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int curretArea = island(grid, i, j);
                    max = Math.max(max, curretArea);
                }
            }
        }
        return max;
    }

    int cnt = 0;
    public int island(int[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        if (visited[i][j] == 0){
            visited[i][j] = 1;

            if(grid[i][j] == 1){
                grid[i][j] = 0;
                cnt = 1;
            }
            cnt+=island(grid, i, j+1);
            cnt+=island(grid, i, j-1);
            cnt+=island(grid, i+1, j);
            cnt+=island(grid, i-1, j);

        }
        return cnt;
    }
}

