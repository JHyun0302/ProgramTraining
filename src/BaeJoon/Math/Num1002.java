package BaeJoon.Math;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1002 {
    static int[][] position;

    public static void helper(int testCase) {
        for (int i = 0; i < testCase; i++) {
            double CenterToCenter = Math.sqrt(Math.pow((position[i][0] - position[i][3]), 2) + Math.pow((position[i][1] - position[i][4]), 2));
            if (CenterToCenter == 0) {
                if (position[i][2] == position[i][5]) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }

            } else {
                if (CenterToCenter > position[i][2] + position[i][5]) {
                    System.out.println(0);
                } else if (CenterToCenter == position[i][2] + position[i][5]) {
                    System.out.println(1);
                } else if (CenterToCenter < position[i][2] + position[i][5]) {
                    System.out.println(2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        position = new int[testCase][6];

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken()); // x1
            position[i][1] = Integer.parseInt(st.nextToken()); // y1
            position[i][2] = Integer.parseInt(st.nextToken()); // r1
            position[i][3] = Integer.parseInt(st.nextToken()); // x2
            position[i][4] = Integer.parseInt(st.nextToken()); // y2
            position[i][5] = Integer.parseInt(st.nextToken()); // r2
        }

        helper(testCase);
    }
}*/

import java.io.*;
import java.util.StringTokenizer;

public class Num1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if (d == 0 && r1 == r2) {
                bw.write("-1");
            } else if (d > Math.abs(r2 - r1) && d < r1 + r2) {
                bw.write("2");
            } else if (Math.abs(r2 - r1) == d || r2 + r1 == d) {
                bw.write("1");
            } else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) {
                bw.write("0");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
