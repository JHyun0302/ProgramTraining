package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회적_거리두기 {
    static int[] sit;
    static int addStudent;
    static int arrLength;

    static int[] newSit;

    public static boolean calc() {
        /**
         * 1이 들어간 위치 찾기
         */
        List<Integer> oneIdx = new ArrayList<>();
        for (int i = 0; i < arrLength; i++) {
            if (sit[i] == 1) {
                oneIdx.add(i);
            }
        }
        for (Integer i : oneIdx) {
            if (i == 0) {
                newSit[i + 1] = 1;
            } else if (i == arrLength - 1) {
                newSit[i - 1] = 1;
            } else {
                newSit[i - 1] = 1;
                newSit[i + 1] = 1;
            }
        }
        /**
         * if(newSit의 0의 개수 > addStudent)
         *  true
         * else
         *  false
         */
        int cnt = 0;
        for (int i = 0; i < newSit.length; i++) {
            if (newSit[i] == 0) {
                cnt++;
            }
        }
        if (cnt >= addStudent)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        while (testCase > 0) {
            st = new StringTokenizer(br.readLine());
            addStudent = Integer.parseInt(st.nextToken());
            arrLength = Integer.parseInt(st.nextToken());
            sit = new int[arrLength];
            newSit = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                sit[i] = Integer.parseInt(st.nextToken());
                newSit[i] = sit[i];
            }
            if (calc()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

            testCase--;
        }

    }
}
/**
 * 4
 * 1 5 1 0 0 0 1
 * 3 5 0 0 0 0 0
 * 2 5 1 0 0 0 1
 * 1 5 0 1 0 1 0
 */