package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num13305 {
    static List<Integer> roadLength = new ArrayList<>();
    static List<Integer> gasStation = new ArrayList<>();

    public static void calc(int city) {
        /**
         * 조건 1: 무조건 처음 주유소에서 처음 가는 거리만큼 넣어야함
         * gasStation.get(0)에서 roadLength.get(0) 만큼 넣기
         *
         * 조건 2: gasStation의 가장 작은 값의 index 찾기
         * 그 index 기준 뒤 roadLength의 합 * gasStation.get(index)
         */
        int i;
        int minGasIndex = Integer.MAX_VALUE;
        for (i = 0; i < city; i++) {
            if (minGasIndex > gasStation.get(i)) {
                minGasIndex = i;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken()); // 도시 수

        st = new StringTokenizer(br.readLine());
        int i;
        for (i = 0; i < city - 1; i++) {
            roadLength.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (i = 0; i < city - 1; i++) {
            gasStation.add(Integer.parseInt(st.nextToken()));
        }

        calc(city);

        System.out.println(answer);

    }
}
