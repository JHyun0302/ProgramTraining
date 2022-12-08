package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 큰_수_만들기 {
    static int input;

    static int[] num;
    static int[] temp;
    static boolean[] visit;
    static Set<Integer> hashset = new HashSet<>();

    static String list = "";

    public static void dfs(int depth) {
        if (depth == input) {
            for (int i : temp) {
                list += i;
            }
            hashset.add(Integer.valueOf(list));
            list = "";
            return;
        }
        for (int i = 0; i < input; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                temp[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            input = Integer.parseInt(st.nextToken());

            num = new int[input];
            temp = new int[input];
            visit = new boolean[input];
            for (int i = 0; i < input; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            int max = Collections.max(hashset);
            System.out.println(max);
            hashset.clear();
            testCase--;
        }

    }
}
/**
 * 2
 * 2 10 2
 * 5 3 30 34 5 9
 */