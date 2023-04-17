package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num2667 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int count = 0, number = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }

        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visit[i][j] == false) {
                    count = 0;
                    number++;
                    dfs(i, j);
                    result.add(count);
                }

            }

        }
        Collections.sort(result);
        System.out.println(number);
        for (Integer integer : result) {
            System.out.println(integer);
        }

    }

    private static void dfs(int row, int col) {
        visit[row][col] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int cx = row + dx[i];
            int cy = col + dy[i];

            if (cx >= 0 && cy >= 0 && cx < n && cy < n) {
                if (visit[cx][cy] == false && map[cx][cy] == 1) {

                    dfs(cx, cy);
                }
            }
        }
    }
}
