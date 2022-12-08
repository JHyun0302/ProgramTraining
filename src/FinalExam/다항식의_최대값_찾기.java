package FinalExam;

import java.util.Random;

public class 다항식의_최대값_찾기 {
    static double maxValue;
    static Random rand;


    public static int findMaxValue() {
        rand = new Random();
        int min = -10;
        int max = 10;
        while (true) {
            maxValue = rand.nextInt(max + min) * min;


            /*if (nums[r] == target) {
                return r;
            }*/

        }
    }

    public static void main(String[] args) {
        System.out.println(findMaxValue());

    }
}
