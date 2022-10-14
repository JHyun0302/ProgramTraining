package Programmers.Graph;

public class 게임_맵_최단거리 {
    int n = 0;
    int m = 0;
    boolean[][] visited;

    public int solution(int[][] maps) {
        int i, j = 0;
        n = maps.length;
        m = maps[0].length;
        int min = Integer.MAX_VALUE;
        visited = new boolean[n][m];
        if (maps[n - 2][m - 1] == 0 && maps[n - 1][m - 2] == 0)
            return -1;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if(maps[i][j] == 1){
                    int current_val = dfs(maps, i, j);
                    min = Math.min(min, current_val);
                }
            }
        }
        return min;
    }

    int cnt = 0;

    public int dfs(int[][] maps, int i, int j) {
        if (i >= m || j >= n || i < 0 || j < 0 ||visited[i][j])
            return 0;
        if (maps[i][j] == 0)
            return 0;


        if (visited[i][j] == false) {
            visited[i][j] = true;


            if (maps[i][j] == 1) {
                maps[i][j] = 0;
                cnt = 1;
            }

           /* if(maps[i][j+1] ){

            }*/

            cnt += dfs(maps, i, j + 1);
            cnt += dfs(maps, i, j - 1);
            cnt += dfs(maps, i + 1, j);
            cnt += dfs(maps, i - 1, j);

        }
        return cnt;
    }
}

