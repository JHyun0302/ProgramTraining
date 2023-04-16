package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1012 {
    static int m, n, k, result;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visit = new boolean[m][n];

            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (arr[a][b] == 1 && visit[a][b] == false) {
                        dfs(a, b);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static void dfs(int a, int b) {
        visit[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int cx = a + dx[i];
            int cy = b + dy[i];

            if (cx >= 0 && cy >= 0 && cx < m && cy < n) {
                if (visit[cx][cy] == false && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }

}
