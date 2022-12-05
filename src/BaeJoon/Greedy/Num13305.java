
package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
public class Num13305 {
    static List<Integer> roadLength = new ArrayList<>();
    static List<Integer> gasStation = new ArrayList<>();

    public static void calc(int city) {
        */
/**
         * 조건 1: 무조건 처음 주유소에서 처음 가는 거리만큼 넣어야함
         * gasStation.get(0)에서 roadLength.get(0) 만큼 넣기
         *
         * 조건 2: gasStation의 가장 작은 값의 index 찾기
         * 그 index 기준 뒤 roadLength의 합 * gasStation.get(index)
         *//*

        int i;
        int result = gasStation.get(0) * roadLength.get(0);
        int roadsum =0;
        int minGasIndex = 1;
        for (i = 1; i < city -1; i++) {
            if (gasStation.get(minGasIndex) > gasStation.get(i)) {
                minGasIndex = i;
            }
        }

        int minGas = 0;

        if(minGasIndex != 1){ // 2번째 주유소가 최저 값이 아닐 때
            for(i =0; i< minGasIndex; i++){
                if(gasStation.get(minGas) > gasStation.get(i)){
                    minGas = i;
                }
            }
            for (i =minGas; i< minGasIndex; i++){
                result += roadLength.get(i) * gasStation.get(minGas);
            }
            for (i =minGasIndex; i< roadLength.size(); i++) {
                roadsum += roadLength.get(i);
            }
            result += roadsum * gasStation.get(minGasIndex);
        }

        else{ // 2번째 주유소가 최저 값일 때
            for(i = minGasIndex; i < roadLength.size(); i++){
                roadsum += roadLength.get(i);
            }
            result += roadsum * gasStation.get(minGasIndex);
        }
        System.out.println(result);
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

        for (i = 0; i < city; i++) {
            gasStation.add(Integer.parseInt(st.nextToken()));
        }

        calc(city);

    }
}
*/

/**
 * 핵심: '내림차순'일 경우에 주유
 * 8, 9, 5, 4, 2, 7, 1  → 8, 8, 5, 4, 2, 2, 1
 *
 */

public class Num13305 {
    static int[] roadLengt;
    static int[] gasStaion;

    public static void calc(int city) {
        long sum = 0;
        long minCost = gasStaion[0];	// 이전 까지의 과정 중 주유 최소 비용

        for(int i = 0; i < city - 1; i++) {
            /*
             *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
             *  minCost를 갱신해준다.
             */
            if(gasStaion[i] < minCost) {
                minCost = gasStaion[i];
            }

            sum += (minCost * roadLengt[i]);
        }

        System.out.println(sum);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken()); // 도시 수

        int i;

        roadLengt = new int[city];
        gasStaion = new int[city];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < city - 1; i++) {
            roadLengt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < city; i++) {
            gasStaion[i] = Integer.parseInt(st.nextToken());
        }

        calc(city);

    }
}