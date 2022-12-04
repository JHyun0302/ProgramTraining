package BaeJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num5430 {
    /**
     * queue 구현
     */
    static int arrLength;
    static StringBuilder sb = new StringBuilder();

    public static void AC(Integer[] arr, String commend) {
        /**
         * R이면 배열 뒤집기
         * D의 개수 > 배열 크기 : error
         */
        ArrayList<Integer> listArr = new ArrayList(Arrays.asList(arr));

        for (char cmd : commend.toCharArray()) {
            int i = 0;
            if (cmd == 'R') {
                Collections.reverse(listArr);
            }

            if (cmd == 'D') {
                if (listArr.isEmpty() == true) {
                    sb.append("error\n");
                    return;
                } else {
                    listArr.remove(i);
                    i++;
                }
            }
        }
        makePrintString(listArr);
    }

    public static void makePrintString(List<Integer> listArr) {
        int i;
        sb.append('[');    // 여는 대괄호 먼저 StringBuilder에 저장

        if (listArr.size() > 0) {    //만약 출력 할 원소가 한 개 이상일 경우
            sb.append(listArr.get(0));    // 먼저 첫 번째 원소를 넘겨준다.

            // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다.
            for (i = 1; i < listArr.size(); i++) {
                sb.append(',').append(listArr.get(i));
            }
        }

        sb.append(']').append('\n');    // 닫는 대괄호 및 개행으로 마무리
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken()); //사람수
        int i, j;

        for (i = 0; i < testCase; i++) {
            String commend = br.readLine(); // R or D
            st = new StringTokenizer(br.readLine());
            arrLength = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[arrLength];

            st = new StringTokenizer(br.readLine(), "[],");
            for (j = 0; j < arrLength; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            AC(arr, commend);
        }
        System.out.println(sb);
    }
}


/*package BaeJoon.Realization;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;
        import java.util.StringTokenizer;

public class Num5430 {
    *//**
 * deque 구현
 * <p>
 * D의 개수 > 배열 크기 : error
 * <p>
 * D의 개수 > 배열 크기 : error
 *//*
    static int arrLength;
    static ArrayDeque<Integer> deque;

    static StringBuilder sb = new StringBuilder();

    public static void AC(String commend) {
        *//**
 * D의 개수 > 배열 크기 : error
 *//*

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken()); //사람수
        int i, j;

        for (i = 0; i < testCase; i++) {
            String commend = br.readLine(); // R or D
            arrLength = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],"); // 특정 delim으로 문자열을 분리
            deque = new ArrayDeque<Integer>();

            for (j = 0; j < arrLength; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(commend);
        }
        System.out.println(sb);

    }
}*/
