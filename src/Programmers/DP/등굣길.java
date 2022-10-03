package Programmers.DP;

public class 등굣길 {
    public class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] way = new int[m + 1][n + 1];
            int row = 1;
            int col = 1;
            int answer = 0;
            int len = puddles.length;
            int i, j;
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++)
                    way[i][j] = -1;
            }
            way[0][0] = 0;
            for (i = 1; i < m; i++)
                way[i][0] = 1;
            for (i = 1; i < n; i++)
                way[0][i] = 1;

            for (i = 0; i < len; i++) {
                way[puddles[i][0] - 1][puddles[i][1] - 1] = 0;
                if (puddles[i][0] - 1 == 0) {
                    for (i = puddles[i][0] - 1; i < m; i++)
                        way[i][0] = 0;
                }
                if (puddles[i][1] - 1 == 0) {
                    for (i = puddles[i][0] - 1; i < n; i++)
                        way[0][i] = 0;
                }
            }

            for (i = 0; i < len; i++) {


            }
            for (i = row; i < m; i++) {
                for (j = col; j < n; j++) {
                    if (way[i][j] == 0)
                        continue;
                    way[i][j] = way[i - 1][j] + way[i][j - 1];
                }
            }
            answer = way[m - 1][n - 1];
            return answer;
        }
    }

}