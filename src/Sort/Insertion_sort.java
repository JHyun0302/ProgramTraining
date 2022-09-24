package Sort;

import java.util.Arrays;

public class Insertion_sort {
    public static void insertsort(int[] arr, int len) {
        int j, i;

        for (i = 1; i < len; i++) {
            int target = arr[i]; //target
            for (j = i - 1; j >= 0 && arr[j] > target; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = target;
        }
    }

    public static void main(String[] args){
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        int len = arr.length;
        insertsort(arr, len);
        System.out.print("Insertion Sort:" );
        System.out.println(Arrays.toString(arr));
    }
}
//[장점]
//1. 메모리 소비 낮음
//2. 거의 정렬 된 경우 매우 효율적. Best: O(N)
//3. 안장정렬이 가능하다.

//[단점]
//1. 역순에 가까울 수록 매우 비효율적. Wrost: O(N2)
//2. 데이터의 상태에 따라서 성능 편차가 매우 크다.