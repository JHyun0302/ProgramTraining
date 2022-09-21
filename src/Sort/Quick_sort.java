package Sort;

public class Quick_sort {
    public static void quicksort(int[] arr) {
        r_pivot_sort(arr, 0, arr.length - 1);
    }

    private static void r_pivot_sort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        r_pivot_sort(arr, low, pivot - 1);
        r_pivot_sort(arr, pivot + 1, high);
    }
    private static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[right];		// 부분리스트의 오른쪽 요소를 피벗으로 설정

        while(lo < hi) {
            while(arr[lo] < pivot && lo < hi) { // pivot보다 arr[lo]가 작은 경우 pass
                lo++;
            }

            while(arr[hi] >= pivot && lo < hi) { // pivot보다 arr[hi]가 큰 경우 pass
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
        quicksort(arr);
        System.out.print("Quick Sort:" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}





//[장점]
//1. 특정 상태가 아닌 이상 평균 시간 복잡도는 NlogN이며, 다른 NlogN 알고리즘에 비해 대체적으로 속도가 매우 빠르다. 유사하게 NlogN 정렬 알고리즘 중 분할정복 방식인 merge sort에 비해 2~3배정도 빠르다.
//2. 추가적인 별도의 메모리를 필요로하지 않으며 재귀 호출 스택프레임에 의한 공간복잡도는 logN으로 메모리를 적게 소비한다.

//[단점]
//1. 특정 조건하에 성능이 급격하게 떨어진다.
//2. 재귀를 사용하기 때문에 재귀를 사용하지 못하는 환경일 경우 그 구현이 매우 복잡해진다.