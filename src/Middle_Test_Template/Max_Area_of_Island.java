package Middle_Test_Template;

public class Max_Area_of_Island {

    static int m;
    static int n;
    static boolean[][] visited;
    static int cnt;
    public static int dfs(int[][] grid, int i, int j){
        if(i<0|| i>= m || j<0 || j>= n || visited[i][j] == true)
            return 0;

        if(grid[i][j] == 0)
            return 0;

        if(visited[i][j] == false){
            visited[i][j] = true;

            if(grid[i][j] == 1){
                grid[i][j] = 0;
                cnt =1;
            }
            cnt += dfs(grid, i+1, j);
            cnt += dfs(grid, i-1, j);
            cnt += dfs(grid, i, j+1);
            cnt += dfs(grid, i, j-1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int i,j;
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m+1][n+1];
        int max=0;
        for(i =0; i< m; i++){
            for(j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int current = dfs(grid, i, j);
                    max = Math.max(max, current);
                }
            }
        }
        System.out.println("max_island: "+ max);
    }

}
