package Leetcode.Ramdomized;

import java.util.Random;

public class Num478 {
    double radius;
    double x_center;
    double y_center;
    Random rand;

    double[] list;

    public Num478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        list = new double[2];
        rand = new Random();
        while (true) {
            double xMax = x_center + radius;
            double xMin = x_center - radius;
            double yMax = y_center + radius;
            double yMin = y_center - radius;
            double x_point = xMin + rand.nextDouble() * (xMax - xMin + 1);
            double y_point = yMin + rand.nextDouble() * (yMax - yMin + 1);
            if (Math.pow(x_point - x_center, 2) + Math.pow(y_point - y_center, 2) <= Math.pow(radius, 2)) {
                list[0] = x_point - x_center;
                list[1] = y_point - y_center;
                return list;
            }
        }
    }
}
