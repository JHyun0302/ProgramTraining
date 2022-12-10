package FinalExam;

import java.text.DecimalFormat;

public class NewtonRaphson {

    public static void main(String[] args) {
        double p0 = 2;
        double TOL = 1.0e-6;   //오차허용한계
        int M = 50;   //최대반복수
        System.out.println("근사적인 근: " + newton(p0, TOL, M));

        //double ret = Math.round(f(newton(p0, TOL, M)) * 100000) / 100000.0;
        System.out.println("y: " + f(newton(p0, TOL, M)));
    }

    //방정식 정의
    public static double f(double x) {
        return -Math.pow(x, 6) + Math.pow(x, 4) + 7 * Math.pow(x, 3) + 9 * Math.pow(x, 2) - 10 * x - 1;
        //return Math.pow(x, 6) - 2 * Math.pow(x, 4) - 3 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + x - 1;
    }


    //자리수를 변환해주는 함수
    public static double cipher(double x, double esp) {
        int figure = (int) Math.abs(Math.log10(esp));
        String pattern = "#.";
        for (int i = 0; i < figure; i++) {
            pattern += "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return Double.parseDouble(df.format(x));
    }


    //1차 미분계수를  구해주는 함수
    public static double derivf(double x) {
        double h = 0.001;
        double value = -f(x + 2 * h) + 8 * f(x + h) - 8 * f(x - h) + f(x - 2 * h);
        return value / (12 * h);
    }

    //Newton 공식 정의
    public static double pn(double p0) {
        return p0 - f(p0) / derivf(p0);
    }


    //Newton-Raphson 방법을 이용한 비선형 방정식 풀이
    public static double newton(double p0, double TOL, int M) {
        double result = 0;
        for (int i = 0; i < M; i++) {
            if (derivf(p0) == 0) {
                System.out.println("미분계수가 0이 되어 더 이상 연산을 진행할 수 없습니다!");
                System.exit(0);
            }

            double p = pn(p0);
            if (Math.abs(p - p0) < TOL) {
                p0 = p;
                break;
            }

            p0 = p;
            result = cipher(p0, TOL);
        }

        if (Math.abs(f(p0)) > TOL) {
            System.out.println("최대반복수" + M + "내에서 수렴하지 않았습니다");
        }
        return result;
    }
}