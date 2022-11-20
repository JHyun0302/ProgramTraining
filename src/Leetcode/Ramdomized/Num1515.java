package Leetcode.Ramdomized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Num1515 {
    static int[][] positions = {{1, 1}, {0, 0}, {2, 0}};

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
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
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
        double Xmiddle = Math.round((double) (xMin + xMax) / xPoint.size() * 100000) / 100000.0;
        double Ymiddle = Math.round((double) (yMin + yMax) / yPoint.size() * 100000) / 100000.0;
        System.out.println(Xmiddle);
        System.out.println(Ymiddle);
        while (true) {
            double xCenter = xMin + rand.nextDouble() * (xMax - xMin);
            double yCenter = yMin + rand.nextDouble() * (yMax - yMin);
            System.out.println(xCenter);
            System.out.println(yCenter);
            double distanceSum = 0;
            if (xCenter == Xmiddle && yCenter == Ymiddle) {
                for (int i = 0; i < xPoint.size(); i++) {
                    distanceSum += euclideanDistance(xCenter, yCenter, xPoint.get(i), yPoint.get(i));
                }
                return distanceSum;
            }
        }
    }


    public static void main(String[] args) {
        double result = getMinDistSum(positions);
        System.out.println(result);
    }
}
