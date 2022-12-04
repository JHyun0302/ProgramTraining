package Leetcode.Greedy;

public class Num1323 {
    public static int maximum69Number(int num) {
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '6') {
                strNum = strNum.replaceFirst("6", "9");
                break;
            }
        }

        return Integer.parseInt(strNum);
    }

    public static void main(String[] args) {
        int result = maximum69Number(9669);
        System.out.println(result);
    }
}
