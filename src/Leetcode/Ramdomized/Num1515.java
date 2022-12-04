package Leetcode.Ramdomized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Num1515 {
    static int[][] positions = {{1, 1}, {0, 0}, {2, 0}};// {{0, 1}, {1, 0}, {1, 2}, {2, 1}}; // {{1, 1}, {3, 3}};

    static Random rand;
    static List<Integer> xPoint = new ArrayList<>();
    static List<Integer> yPoint = new ArrayList<>();


    public static double euclideanDistance(double xCenter, double yCenter, double x1, double y1) {
        return Math.sqrt(Math.pow((x1 - xCenter), 2) + Math.pow((y1 - yCenter), 2));
    }

    public static double getMinDistSum(int[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            xPoint.add(positions[i][0]);
            yPoint.add(positions[i][1]);
        }

        rand = new Random();
        double xMin = Integer.MAX_VALUE;
        double xMax = Integer.MIN_VALUE;
        double yMin = Integer.MAX_VALUE;
        double yMax = Integer.MIN_VALUE;
        for (Integer integer : xPoint) {
            if (xMin > integer) {
                xMin = integer;
            }
            if (xMax < integer) {
                xMax = integer;
            }
        }
        for (Integer integer : yPoint) {
            if (yMin > integer) {
                yMin = integer;
            }
            if (yMax < integer) {
                yMax = integer;
            }
        }
        double xRange;
        double yRange;
        double distanceSum = Integer.MAX_VALUE;
        double temp;
        double saveX = 0;
        double saveY = 0;

        /**
         * 아래 for문을 통해 오차범위 0.1까지 뽑아낸다.
         */
        for (double i = xMin; i <= xMax; ) {
            xRange = i;
            for (double j = yMin; j <= yMax; ) {
                yRange = j;
                temp = 0; // 점들까지 거리 합
                for (int k = 0; k < xPoint.size(); k++) {
                    temp += euclideanDistance(xRange, yRange, xPoint.get(k), yPoint.get(k));
                }
                if (distanceSum > temp) {
                    distanceSum = temp;
                    saveX = xRange;
                    saveY = yRange;
                }
                j += 0.1;

            }
            i += 0.1;
        }
        /**
         * while문을 통해 오차범위를 0.01 -> 0.001 -> 0.0001 -> 0.00001까지 줄인다.
         */
        System.out.println(saveX);
        System.out.println(saveY);
        int num = 1;
        while (num < 5) {
            for (double i = saveX - (1 / Math.pow(10, num)); i <= saveX + (1 / Math.pow(10, num)); ) {
                xRange = i;
                for (double j = saveY - (0.1 / Math.pow(10, num)); j <= saveY + (0.1 / Math.pow(10, num)); ) {
                    yRange = j;
                    temp = 0; // 점들까지 거리 합
                    for (int k = 0; k < xPoint.size(); k++) {
                        temp += euclideanDistance(xRange, yRange, xPoint.get(k), yPoint.get(k));
                    }
                    if (distanceSum > temp) {
                        distanceSum = temp;
                        saveX = xRange;
                        saveY = yRange;
                    }
                    j += (1 / Math.pow(10, num + 1));
                }
                i += (1 / Math.pow(10, num + 1));
            }
            num++;

        }

        System.out.println(saveX);
        System.out.println(saveY);
        /**
         * 1번 for문: xCenter의 값을 정해줌
         * 2번 for문: yCenter의 값을 정해줌
         * 3번 for문: 각 점들까지 거리 합을 구함
         * 처음에 오차범위를 0.1로 생각하고 0.1씩 올리면서 값을 찾는다
         * 1번째에서 찾은 값의 오차범위를 줄이기 위해 0.01로 오차범위로 두고 또 찾는다
         * 다음의 오차범위는 0.01로 두고 또 찾는다.
         * ...
         * 마지막으로 오차범위가 0.00001로 두고 값을 찾는다...
         */

        return distanceSum;
    }


    public static void main(String[] args) {
        double result = getMinDistSum(positions);
        System.out.println(result);
    }
}