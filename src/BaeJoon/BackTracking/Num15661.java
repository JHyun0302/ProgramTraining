package BaeJoon.BackTracking;

import java.util.*;

public class Num15661 {
    static int N;
    static boolean visit[];
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visit[i] && visit[j]) {
                    start += map[i][j];
                    start += map[j][i];
                }
                if (!visit[i] && !visit[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
}