package FinalExam;

public class 다항식의_최대값_찾기 {

    public static double findMaxValue() {
        double result = 0;

        for (double pt = 10; pt >= 0.0001; pt /= 10) {
            for (double x = -10; x <= 10; x += pt) {
                result = Math.min(result, solve(x));
            }
        }

        return result;
    }

    static double solve(double x) {
        return (Math.pow(x, 6) - 2 * Math.pow(x, 4) - 3 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + x - 1);
    }

    public static void main(String[] args) {
        double ret = findMaxValue();
        System.out.println("y: " + ret);
    }
}
