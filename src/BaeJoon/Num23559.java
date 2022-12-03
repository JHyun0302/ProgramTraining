package BaeJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num23559 {
    public static int selectLunch(int day, int money, int[][] menu, int sum) {
        int i;
        // 5000원짜리 맛 내림차순 정렬
        Arrays.sort(menu, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int oper1 = o1[1] - o1[0];
                int oper2 = o2[1] - o2[0];

                return oper1 - oper2;
            }
        });

        int fiveThCnt = money / 5000;  // 5000원 개수
        int oneThCnt = money % 5000;
        for (i = 0; menu[i][0] > menu[i][1] && fiveThCnt > 0; i++) {
            if (day >= 2 && money <= fiveThCnt * 5000) {
                fiveThCnt = 0;
            }
            sum -= menu[i][1];
            sum += menu[i][0];
            fiveThCnt--;
            day--;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[][] menu = new int[day][2];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            menu[i][0] = Integer.parseInt(st.nextToken());
            menu[i][1] = Integer.parseInt(st.nextToken());
            sum += menu[i][1]; // 1000원권 모두 더하고 시작
        }

        System.out.println(selectLunch(day, money, menu, sum));
    }
}
