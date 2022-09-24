package Search;
import java.util.Scanner;

public class Binary_search {
    static int recur_binarySearch(int[] arr, int key, int left, int right) {
        int mid;
        if(left <= right) {
            mid = (left + right) / 2;
            if(key == arr[mid]) return mid;
            else if(key < arr[mid]) return recur_binarySearch(arr, key ,left, mid-1); // 왼쪽 탐색
            else return recur_binarySearch(arr, key, mid+1, right); // 오른쪽 탐색
        }
        return -1;
    }

    static int iter_binarySearch(int[] arr, int key, int left, int right) {
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(key == arr[mid]) return mid;
            else if(key < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100, 200, 1000};
        System.out.println("사용할 호출 방법을 선택하세요.");
        System.out.println("1. 순환 호출 2. 반복 호출");
        Scanner way = new Scanner(System.in);
        int num = way.nextInt();

        System.out.println("{1, 3, 5, 7, 8, 10, 20, 35, 99, 100, 200, 1000} 중 ");
        System.out.print("검색할 데이터를 입력하세요: ");
        Scanner find = new Scanner(System.in);
        int search = find.nextInt();

        if(num == 1) {
            System.out.print("1. 순환 호출을 이용한 이진 탐색: ");
            System.out.println(recur_binarySearch(arr, search, 0, arr.length-1)); // 2
        }

        else if(num == 2) {
            System.out.print("2. 반복을 이용한 이진 탐색: ");
            System.out.println(iter_binarySearch(arr, search, 0, arr.length-1)); // 6
        }
        way.close();
        find.close();
    }
}