package Leetcode.BackTracking;
import java.util.ArrayList;
import java.util.List;

public class Num401 {
    public static List<String> readBinaryWatch(int num) {
        int[] list = new int[10];
        List<String> res = new ArrayList<String>();
        dfs(res, list, 0, 0, num);
        System.out.println(res);
        return res;
    }

    private static void dfs(List<String> res, int[] list, int depth, int index, int num) {
        if (depth == num) {
            int hour = 0, min = 0, i = 0;
            for (; i < 4; i++)
                hour = hour*2 + list[i];
            for (; i < 10; i++)
                min = min*2 + list[i];
            if (hour < 12 && min < 60)
                res.add(hour + ":" + (min < 10 ? "0" : "") + min);
            return;
        }
        for (int i = index; i < 10; i++) {
            list[i] = 1;
            dfs(res, list, depth + 1, i + 1, num);
            list[i] = 0;
        }
    }

    public static void main(String[] args) {
        readBinaryWatch(1);

    }
}

/*package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num401 {
    static int[] arr;
    static int[] time ={480, 240, 120, 60, 1, 2, 4, 8, 16, 32};
    static int hour;
    static int minute;
    static String timer;
    static int sum_hour;
    static int sum_minute;

    public static List<String> readBinaryWatch(int turnedOn) {
        arr = new int[turnedOn];
        List<String> answer = new ArrayList<>();
        if(turnedOn == 0) {
            answer.add("0:00");
            return answer;
        }
        if(turnedOn >= 9)
            return answer;
        backtracking(0, turnedOn, answer);
        System.out.println(answer);
        Collections.sort(answer);
        return answer;
    }
    public static void backtracking(int depth, int turnedOn, List<String> answer){
        if(depth == turnedOn){
            sum_minute =0;
            sum_hour =0;
            for(int val: arr){
                hour = val / 60;
                minute = val % 60;
                sum_hour += hour;
                sum_minute += minute;
            }
            if(sum_minute >= 60)
                MinuteToHour();
            print();
            CheckOverHour(answer);
            return;
        }
        for(int i =0; i<time.length; i++){
            arr[depth] = time[i];
            backtracking(depth+1, turnedOn, answer);
        }
    }
    public static void CheckOverHour(List<String> answer){
        if(sum_hour < 12 && !answer.contains(timer))
            answer.add((timer));
    }
    static int cnt =0;
    public static void MinuteToHour(){
        cnt =0;
        while(sum_minute>60){
            cnt = sum_minute / 60;
            sum_minute %= 60;
            sum_hour += cnt;
        }
    }
    public static void print(){
        if(sum_minute < 10)
            timer = sum_hour + ":0" + sum_minute;
        else
            timer = sum_hour + ":" + sum_minute;
    }
    public static void main(String[] args) {
        readBinaryWatch(3);
    }
}*/

