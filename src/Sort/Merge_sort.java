package Sort;

import java.util.Arrays;

public class Merge_sort {
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] sorted = new int[right+1];
        int i = left;
        int j = mid+1;
        int k = left;
        int l;

        /* 분할 정렬된 list의 합병 */
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }
        // 나머지 복사
        if(i>mid)
            for(l=j; l<=right; l++)
                sorted[k++] = arr[l];
        else
            for(l=i; l<=mid; l++)
                sorted[k++] = arr[l];

        for(l=left; l<=right; l++){
            arr[l] = sorted[l];
        }
    }

    public static void merge_sort(int[] arr, int left, int right) {
        int mid;

        if (left < right) {
            mid = (left + right) / 2;
            merge_sort(arr, left, mid); //left partition
            merge_sort(arr, mid + 1, right); //right partition
            merge(arr, left, mid, right); //merge
        }

    }
    public static void main(String[] args){
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        int len = arr.length;
        merge_sort(arr, 0, len-1);
        System.out.print("Merge Sort:" );
        System.out.println(Arrays.toString(arr));
    }
}

//[장점]
//1. Worst: O(NlogN)
//2. 안정정렬이다.

//[단점]
//1. 메모리 사용량이 많음.
//2. 데이터가 많을경우 상대적으로 시간 소모 큼.




