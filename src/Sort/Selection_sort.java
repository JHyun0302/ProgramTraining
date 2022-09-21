package Sort;

public class Selection_sort {
    public static void selectionsort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            int min_index = i; // 최솟값을 갖고있는 인덱스 찾기
            for(int j = i + 1; j < len; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j; //min_index 갱신
                }
            }
            // i번째 값과 찾은 최솟값을 서로 교환
            swap(arr, min_index, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        selectionsort(arr);
        System.out.print("Selection Sort:" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


//[장점]
//1. 추가적인 메모리 소비가 작다.

//[단점]
//1. 시간복잡도가 O(N2) 이다.
//2. 안정 정렬이 아니다.