package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num13164 {
    static int children;
    static int numberOfTeam;
    static int[] childrenList;
    static int[] diff;
    static int sum =0;
    public static void makeTeam(){
        int i, j =0;
        int range = children - numberOfTeam;
        for (i = 0; i < range; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        children = Integer.parseInt(st.nextToken());
        numberOfTeam = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        childrenList = new int[children];
        diff = new int[children - 1];
        for(int i =0; i<childrenList.length; i++){
            childrenList[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(childrenList[i] - childrenList[i + 1]);
        }
        Arrays.sort(diff);
        makeTeam();
    }
}
