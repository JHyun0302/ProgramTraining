package Sort;

import java.util.Arrays;

public class Quick_sort {
    public static void quick_sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quick_sort(arr, left, pivot - 1);
        quick_sort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[right];		// 부분리스트의 오른쪽 요소를 피벗으로 설정

        while(lo < hi) {
            while(arr[lo] < pivot) { // arr[lo]보다 pivot가 큰 경우 pass
                lo++;
            }
            while(arr[hi] >= pivot && lo < hi) { // arr[hi]보다 pivot가 작은 경우 pass
                hi--;
            }
            swap(arr, lo, hi); // 그 외의 경우 swap!
        }
        swap(arr, right, hi); //마지막으로 pivot과 arr[hi] swap!
        return hi; // pivot값 return
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int [] arr = {11, 123, 2, 6, 4, 3, 7, 5};
        int len = arr.length;
        quick_sort(arr, 0,len-1);
        System.out.print("Quick Sort:" );
        System.out.println(Arrays.toString(arr));
    }
}

//[장점]
//1. Avg: NlogN, 다른 NlogN 알고리즘에 비해 빠름.
//2. 추가적인 메모리를 필요 X.

//[단점]
//1. 재귀를 사용하지 못하는 환경일 경우 구현이 매우 복잡함.