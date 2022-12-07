package BaeJoon.BackTracking;

import java.io.IOException;
import java.util.Scanner;

public class Num14889 {
    static int N;
    static int M;
    static int[][] S;
    static boolean[] vis;

    static int[][] diff;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        vis = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += i;
        }
        diff = new int[N][N];
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[i].length; j++) {
                S[i][j] = sc.nextInt();
            }
        }


        perm(0, 0);
        System.out.println(Min);
    }

    public static void perm(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!vis[i]) {
                vis[i] = true;
                perm(i + 1, count + 1);
                vis[i] = false;
            }
        }
    }

    public static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (vis[i] == true && vis[j] == true) {
                    team_start += S[i][j];
                    team_start += S[j][i];
                } else if (vis[i] == false & vis[j] == false) {
                    team_link += S[i][j];
                    team_link += S[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }
}