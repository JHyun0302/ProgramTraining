package Select;

/*-----------------------------------------------------------------------
Select 문제. 교재의 평균 선형시간 선택 알고리듬을 구현하시오.

입력: input_data.txt
각 입력은 다음과 같이 구성되어 있다.
입력 file 형식
M     // 선택을 위한 입력 케이스의 수
N k  // 첫 번째 리스트의 길이(N)과 k번째 작은 값을 구하는 입력
n1    // 선택을 위한 첫 번째 수 리스트
n2
n3
...
nN
(빈줄)
N k  // 두 번째 리스트의 길이(N)과 k번째 작은 값을 구하는 입력
n1    // 선택을 위한 두 번째 수 리스트
n2
n3
...
nN

조건:
1. 정렬을 위한 입력 케이스의 수는 100이다.
2. 입력되는 수의 갯수(N)는 [1, 100000]이다.
3. 입력되는 k 값의 크기는 [1, N]이다.

예시)
입력: input_data.txt
3
4 2
10
20
30
40

3 3
50
60
70

7 4
4
5
6
7
6
8
2

출력: output_data.txt
20
70
6

정답은 expected_data.txt로 주어짐
결과는 output_data.txt file로 출력해야 함

주어진 함수에는 프로그래밍 언어에서 제공하는 정렬 기법을 이용해 선택 결과 값을 구하고 있음
선택 함수를 새로 구현하시오. 프로그래밍 언어에서 제공되는 정렬 함수, sort()등을 이용하면 안됨
-----------------------------------------------------------------------*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class select
{
    public static int select(int[] arr, int len) {
        /*int min_index = 0;
        for (int i = 0; i < len - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j; //min_index 갱신
                }
            }
            // i번째 값과 찾은 최솟값을 서로 교환
            swap(arr, min_index, i);
        }
        System.out.println(arr[len-1]);*/
        Arrays.sort(arr);
        return arr[len-1];
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            File input = new File("input_data.txt"); // input data
            FileWriter output = new FileWriter("output_data.txt"); // your answer

            Scanner datain = new Scanner(input);
            int M = datain.nextInt();
            long start_time = System.currentTimeMillis();
            for(int i=0; i<M; i++) {
                int N = datain.nextInt();
                int k = datain.nextInt();
                int[] nums = new int[N];
                for(int j=0; j<N; j++) {
                    nums[j] = datain.nextInt();
                }

                int kth_element = select(nums, k);
                output.write(kth_element + "\n");
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
