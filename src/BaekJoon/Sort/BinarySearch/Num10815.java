package BaekJoon.Sort.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10815 {
    static int n, m;
    static int[] sgCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sgCard = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sgCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sgCard);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int compare = Integer.parseInt(st.nextToken());

            if (binarySearch(compare)) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }


        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static boolean binarySearch(int compare) {
        int leftIndex = 0;
        int rightIndex = n - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = sgCard[midIndex];

            if (compare < mid) {
                rightIndex = midIndex - 1;
            } else if (compare > mid) {
                leftIndex = midIndex + 1;
            } else return true;
        }
        return false;
    }
}
