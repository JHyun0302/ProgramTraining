package Sort;

public class Insertion_sort {
    public static void insertsort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int target = arr[i]; //target
            int j = i - 1; //비교 대상

            while (j >= 0 && target< arr[j]) {
                arr[j + 1] = arr[j]; // 비교대상이 큰 경우 오른쪽으로 밀어냄
                j--;
            }

            arr[j + 1] = target;//기준값 저장
        }

    }

    public static void main(String[] args){
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        insertsort(arr);
        System.out.print("Insertion Sort:" );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//[장점]
//1. 추가적인 메모리 소비가 작다.
//2. 거의 정렬 된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간복잡도를 갖는다.
//3. 안장정렬이 가능하다.

//[단점]
//1. 역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N2)의 시간 복잡도를 갖는다.
//2. 데이터의 상태에 따라서 성능 편차가 매우 크다.