package BaekJoon.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1149 {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        func(n, cost);
    }

    private static void func(int n, int[][] cost) {
        for (int i = 1; i < n; i++) {
            cost[i][Red] += Math.min(cost[i - 1][Green], cost[i - 1][Blue]);
            cost[i][Green] += Math.min(cost[i - 1][Red], cost[i - 1][Blue]);
            cost[i][Blue] += Math.min(cost[i - 1][Red], cost[i - 1][Green]);
        }

        System.out.println(Math.min(Math.min(cost[n - 1][Red], cost[n - 1][Green]), cost[n - 1][Blue]));
    }
}
