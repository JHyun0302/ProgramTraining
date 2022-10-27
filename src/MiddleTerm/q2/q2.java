package MiddleTerm.q2;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class q2
{
    //static int result;
    static  int[] memo;
    public static int solution(int f1, int f2, int n)
    {
/*       memo  = new int[n+1];
        if(n <= 1)
            return n;
        if(memo[n] != 0)
            return memo[n];
        else
            memo[n] = 2*solution(f1, f2, n-1) +3*solution(f1, f2, n-2) ;
       return 2* memo[n-1] + 3*memo[n-2];*/


       if(n==1){return f1;}
       else if(n==2){return f2;}
        memo  = new int[n+1];
       memo[1] = f1;
       memo[2] = f2;
       for(int i =3; i<=n;i++)
       {
           memo[i] = 2*memo[i-1] + 3*memo[i-2];
       }
       return memo[n];
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
                int f1 = datain.nextInt();
                int f2 = datain.nextInt();
                int n = datain.nextInt();
                int result = solution(f1, f2, n);
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
