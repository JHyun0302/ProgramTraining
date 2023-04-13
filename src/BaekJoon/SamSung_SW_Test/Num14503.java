package BaekJoon.SamSung_SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14503 {
    private static int N, M, r, c, pos, room[][];
    static int dy[] = {-1, 0, 1, 0};  // 북동남서
    static int dx[] = {0, 1, 0, -1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        pos = Integer.parseInt(st.nextToken()); //방향
        result = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, pos);
        System.out.println("result = " + result);

    }

    private static void dfs(int r, int c, int pos) {
        room[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            pos = (pos + 3) % 4; // 왼쪽 방향 변환 (북 -> 서 -> 남 -> 동)
            int ny = r + dy[pos];
            int nx = c + dx[pos];

            if (ny >= 0 && ny < M && nx >= 0 && room[ny][nx] == 0) {
                result++;
                dfs(ny, nx, pos);

                return;
            }
        }

        int back = (pos + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if (by >= 0 && by < N && bx >= 0 && bx < M && room[by][bx] != 1) {
            dfs(by, bx, pos);
        }
    }
}
