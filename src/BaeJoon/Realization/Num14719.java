package BaeJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14719 {
    static int width;
    static int height;
    static int[] arr;
    public static void calc(){
        int result = 0;
        for(int i = 1; i < width - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }
            for(int j = i + 1; j < width; j++) {
                right = Math.max(arr[j], right);
            }
            if(arr[i] < left && arr[i] < right)
                result += Math.min(left, right) - arr[i];
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[width];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        calc();
    }
}
