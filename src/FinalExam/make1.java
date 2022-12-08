package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class make1 {
    static int num;

    static List<Integer> list = new ArrayList<>();

    public static void dfs(int num, int cnt) {
        if (num == 1) {
            list.add(cnt);
            return;
        }
        if (num % 2 == 0) {
            dfs(num / 2, cnt + 1);
        }
        if (num % 2 == 1) {
            dfs(num - 1, cnt + 1);
            dfs(num + 1, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            dfs(num, 0);
            Collections.sort(list);
            System.out.println(list.get(0));
            list.clear();
            testCase--;
        }
    }
}

/**
 * 2
 * 8
 * 34
 */
