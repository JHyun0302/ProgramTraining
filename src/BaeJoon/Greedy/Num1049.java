package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1049 {
    static int need;
    static int brand;
    static int[] packages;
    static int[] unit;

    public static void calc(){
        int min = Integer.MAX_VALUE;
        min = Math.min(((need/6)+1)*packages[0], need*unit[0]);
        min = Math.min(min, ((need/6))*packages[0] + (need%6)*unit[0]);

        System.out.println(min);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        need = Integer.parseInt(st.nextToken());
        brand = Integer.parseInt(st.nextToken());
        packages =new int[brand];
        unit = new int[brand];
        for(int i =0; i<brand; i++){
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            unit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packages);
        Arrays.sort(unit);

        calc();
    }
}

