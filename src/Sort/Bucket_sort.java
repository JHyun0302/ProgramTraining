package Sort;
import java.util.Arrays;

public class Bucket_sort{
    public static void bucketsort(int[] arr, int bucketsize) {
        int [] bucket =new int[bucketsize+1];
        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0; // 0으로 bucket 초기화
        }

        for (int i=0; i<arr.length; i++) {
            bucket[arr[i]]++; //arr[i] 값에 따라 bucket의 index 증가
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) { //arr에 저장할 숫자
            for (int j=0; j<bucket[i]; j++) { //같은 숫자가 몇개 있는지 count
                arr[outPos++]=i;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr= {10, 6, 5,3,0,2,4,1,0,5,2,3,1,4};
        int bucketsize= arr.length;
        System.out.println("Bucket Sort" );
        System.out.println("Before: " + Arrays.toString(arr));
        bucketsort(arr,bucketsize);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}

