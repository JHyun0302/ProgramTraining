package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num2212 {
    static int numberOfSensor;
    static int installMachine;

    static int[] arr;
    static Integer[] diff;

    public static void helper(){
        int cnt =0;
        for(int i =0; i<arr.length-1; i++){
            diff[i] = Math.abs(arr[i] - arr[i + 1]);
        }
        Arrays.sort(diff, Comparator.reverseOrder());

        for(int i = installMachine-1; i < diff.length; i++){
            cnt += diff[i];
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfSensor = Integer.parseInt(br.readLine());
        installMachine = Integer.parseInt(br.readLine());
        arr = new int[numberOfSensor];
        diff = new Integer[arr.length - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        helper();
    }
}
