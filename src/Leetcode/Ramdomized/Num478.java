package Leetcode.Ramdomized;

import java.util.Random;

public class Num478 {
    static double radius = 1.0;
    static double x_center = 0.0;
    static double y_center = 0.0;
    static Random rand;

    static double[] list;

    public Num478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public static void main(String[] args) {
        double[] answer = new double[2];
        answer = randPoint();
        for (double i : answer) {
            System.out.println(i);
        }
    }

    public static double[] randPoint() {
        list = new double[2];
        rand = new Random();
        while (true) {
            double xMax = x_center + radius;
            double xMin = x_center - radius;
            double yMax = y_center + radius;
            double yMin = y_center - radius;
            double xPoint = xMin + rand.nextDouble() * (xMax - xMin); // (xMax - xMin + 1) ==  2 * radius +1
            double yPoint = yMin + rand.nextDouble() * (yMax - yMin);
            /**
             * 0 <= Math.random() < 1
             * 0 <= 리턴값  < (최대값 - 최소값)
             * 최소값 <= 리턴값 < 최대값
             *
             * 원하는 값 = math.random() * (최댓값 - 최소값) + 최소값
             * (math.random() * (최댓값 - 최소값) => 0~(최대  - 최소))
             */
            if (Math.pow(xPoint - x_center, 2) + Math.pow(yPoint - y_center, 2) <= Math.pow(radius, 2)) {
                list[0] = xPoint - x_center;
                list[1] = yPoint - y_center;
                return list;
            }
        }
    }
}
