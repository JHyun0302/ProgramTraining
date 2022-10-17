package Programmers.Graph;

public class Network {
    int answer = 0;
    int m;
    int n;
    boolean visited[][];
    public int solution(int n, int[][] computers) {
        int ans =0;
        int max =0;
        int i,j;
        m = computers.length;
        n = computers[0].length;
        visited = new boolean[m+1][n+1];
        for(i=0; i<m; i++){
            for(j =0; j<n; j++){
                ans = dfs(computers, i,j);
                max = Math.max(max, ans);
            }
            ans =0;
        }
        return ans;
    }
    public int dfs(int[][] grid, int i, int j){
        int cnt =0;
        if(i < 0 || i >= m || j<0 || j>= n)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        if(visited[i][j] == false){
            visited[i][j] = true;

            if(grid[i][j] == 1){
                grid[i][j] = 0;
                cnt =1;
            }
            cnt += dfs(grid, i-1, j);
            cnt +=dfs(grid, i+1, j);
            cnt +=dfs(grid, i, j-1);
            cnt += dfs(grid, i, j+1);

        }
        return cnt;
    }

}
