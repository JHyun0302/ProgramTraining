package Middle_Test_Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class step_stone {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            int size = Integer.parseInt(st.nextToken());
            int []cost = new int [size];
            System.out.println("size: " + size);
            for(int j = 0; j < size; j++) {
                int k = Integer.parseInt(st.nextToken());
                cost[j] = k;
            }
            for(int k = 2; k < cost.length; k++) {
                cost[k] = Math.min(cost[k-1], cost[k-2]) + cost[k];

            }
            ans = Math.min(cost[cost.length- 1], cost[cost.length-2]);
            System.out.println(ans);
        }
    }


}
