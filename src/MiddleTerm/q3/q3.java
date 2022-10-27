/*
package MiddleTerm.q3;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;


public class q3
{
    static List<Integer> dp;

    public static int solution(int[] money, int N, int amount)
    {
        int i, j=0;
        dp = new ArrayList<>();
        for(i =0; i< money.length; i++){
            dp.add(money[i]);

        for(i =0; i< money.length; i++){
            for(j =0; j< i; j++){
                dp.add(dp.get(i) + dp.get(j));
            }
        }
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
                int amount = datain.nextInt();
                int N = datain.nextInt();
                int[] money = new int[N];
                for(int j=0; j<N; j++) {
                    money[j] = datain.nextInt();
                }
                int result = solution(money, N, amount);
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
*/
