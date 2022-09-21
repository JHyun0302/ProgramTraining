package Sort;

public class Merge_sort {
    private static int[] temp;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열
    public static void mergesort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        merge_sort(arr, 0, len - 1);
        temp = null;
    }

    // Top-Down 방식 구현
    private static void merge_sort(int[] arr, int left, int right) {
        if(left == right) return; //left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우, 더이상 쪼갤 수 없으므로 return한다.

        int mid = (left + right) / 2;	// 절반 위치
        merge_sort(arr, left, mid);		// 절반 중 왼쪽 부분리스트(left ~ mid)
        merge_sort(arr, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)
        merge(arr, left, mid, right);		// 병합작업
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;		// temp에 채워넣을 배열의 인덱스

        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) { //a[l]가 작은 경우 temp배열에 a[l]저장하고 다음 숫자 비교
                temp[idx] = a[l];
                idx++;
                l++;
            }
            else {
                temp[idx] = a[r]; //a[r]가 작은 경우 temp배열에 a[r]저장하고 다음 숫자 비교
                idx++;
                r++;
            }
        }

        if(l > mid) { // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
            while(r <= right) {
                temp[idx] = a[r];
                idx++;
                r++;
            }
        }
        else { //오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
            while(l <= mid) {
                temp[idx] = a[l];
                idx++;
                l++;
            }
        }

        for(int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String[] args){
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        mergesort(arr);
        System.out.print("Merge Sort:" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


//[장점]
//1. 항상 두 부분리스트로 쪼개어 들어가기 때문에 최악의 경우에도 O(NlogN) 으로 유지가 된다.
//2. 안정정렬이다.

//[단점]
//1. 정렬과정에서 추가적인 보조 배열 공간을 사용하기 때문에 메모리 사용량이 많다.
//2. 보조 배열에서 원본배열로 복사하는 과정은 매우 많은 시간을 소비하기 때문에 데이터가 많을경우 상대적으로 시간이 많이 소요된다.




