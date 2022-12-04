package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Num2437 {
    public static int calc(List<Integer> weight) {
        int answer = 1;
        int i;
        /**
         * weight에 answer와 같은 숫자가 있으면 answer++;
         * 같은 숫자가 없을경우
         * answer보다 작은 숫자를 내림차순으로 정렬(새로운 배열 or 리스트 필요)
         * 작은 숫자들로 구성된 배열에서 나올 수 있는 경우의 수와 answer와 같은 값 찾기
         * answer와 같은 값 없으면 answer가 답임!
         */

        boolean answercnt;
        int sum;
        while (true) {
            answercnt = false;
            for (i = 0; i < weight.size(); i++) {
                if (answer == weight.get(i)) {
                    answer++;
                    answercnt = true;
                    break;
                }
            }
            if (answercnt == false) {
                List<Integer> lowNumber = new ArrayList<>();
                for (i = 0; i < weight.size(); i++) {
                    if (answer > weight.get(i)) {
                        lowNumber.add(weight.get(i));
                    }
                }
                Collections.sort(lowNumber, Collections.reverseOrder());
                if (answer == findAnswerNum(lowNumber, answer)) {
                    answer++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }

    public static int findAnswerNum(List<Integer> lowNumber, int answer) {
        int sum = lowNumber.get(0);
        int i;

        for (i = 1; i < lowNumber.size(); i++) {
            if (answer != sum) {
                sum += lowNumber.get(i);
            }
            if (answer < sum) {
                sum -= lowNumber.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int numberOfWeight = Integer.parseInt(st.nextToken());
        List<Integer> weight = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfWeight; i++) {
            weight.add(Integer.parseInt(st.nextToken()));
        }
        int answer = calc(weight);
        System.out.println(answer);
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWeight = sc.nextInt();
        int[] weight = new int[numberOfWeight];
        int sum = 1;
        for (int i = 0; i < numberOfWeight; i++)
            weight[i] = sc.nextInt();

        Arrays.sort(weight);
        for (int i = 0; i < weight.length; i++) {
            if (sum < weight[i])
                break;
            sum += weight[i];
        }

        System.out.println(sum);
        sc.close();
    }
}*/
