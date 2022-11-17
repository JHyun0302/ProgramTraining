package Leetcode.Ramdomized;

import java.util.ArrayList;
import java.util.List;

public class Num1515 {
    public static double getMinDistSum(int[][] positions) {
        List<Integer> xPoint = new ArrayList<>();
        List<Integer> yPoint = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            xPoint.add(positions[i][0]);
            yPoint.add(positions[i][1]);
        }
        double xCenter = 0;
        double yCenter = 0;
        for (Integer integer : xPoint) {
            xCenter += integer;
        }
        for (Integer integer : yPoint) {
            yCenter += integer;
        }
        xCenter /= xPoint.size();
        yCenter /= yPoint.size();

        double radius = Math.sqrt(Math.pow(xCenter - positions[0][0], 2) + Math.pow(yCenter - positions[0][1], 2));
        double length = radius * xPoint.size();
        return length;
    }

    public static void main(String[] args) {
        int[][] positions = {{1, 1}, {0, 0}, {2, 0}};
        double result = getMinDistSum(positions);
        System.out.println(result);
    }
}
