package MiddleTerm.q4;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class q4
{

    static int[] unf;
    static int cnt =0;
    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static int solution(int[][] friendList, int friendListSize, int f)
    {
        unf = new int[100001];
        for (int i = 1; i < unf.length; i++) unf[i] = i;
        for (int i = 1; i <= friendListSize; i++) {
            int a = friendList[i][0];
            int b = friendList[i][1];
            Union(a, b);
            cnt++;
        }
        int me = Find(0);
        int friend = Find(f);
        if (me == friend)
            return cnt -1;
        else
            return -1;

    }

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            File input = new File("input_data.txt"); // input data
            FileWriter output = new FileWriter("output_data.txt"); // your answer

            Scanner datain = new Scanner(input);
            int K = datain.nextInt();
            long start_time = System.currentTimeMillis();
            for(int i=0; i<K; i++) {
                int m = datain.nextInt();
                int f = datain.nextInt();
                int[][] edges = new int[m][2];
                for(int j=0; j<m; j++) {
                    int u = datain.nextInt();
                    int v = datain.nextInt();
                    edges[j][0] = u;
                    edges[j][1] = v;
                }
                int result = solution(edges, m, f);
                output.write(result + "\n");
            }
            datain.close();
            output.close();
            long end_time = System.currentTimeMillis();
            // DO NOT EDIT. Checking answers
            System.out.printf("Elapsed time: %.2f seconds. ", (float)(end_time - start_time) / 1000);
            compare_output("output_data.txt", "expected_data.txt");
        } catch (IOException e) {
            System.out.println("FileWriter error");
            e.printStackTrace();
        }
    }

    public static void compare_output(String file1, String file2)
    {
        File f1 = new File(file1);
        File f2 = new File(file2);
        try {
            Scanner result = new Scanner(f1);
            Scanner expected = new Scanner(f2);

            int i = 1;
            Boolean success = true;

            while(result.hasNextLine() && expected.hasNextLine()) {
                String line1 = result.nextLine().trim();
                String line2 = expected.nextLine().trim();
                if (!line1.equals(line2)) {
                    System.out.println("[" + i + "] Wrong answer: Yours=\'" + line1 + "\', Expected=\'" + line2 + "\'");
                    success = false;
                    break;
                }
                i++;
            }
            if (!expected.hasNextLine() && success) System.out.println("Success!");
            result.close();
            expected.close();
        } catch (IOException e) {
            System.out.println("FileWriter error");
            e.printStackTrace();
        }
    }
}
