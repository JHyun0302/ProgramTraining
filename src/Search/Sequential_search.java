package Search;
import java.util.Scanner;

public class Sequential_search {

    public static int sequentialSearch(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 14, 2, 10, 11, 16, 20, 50, 100, 200, 1000 };
        System.out.println("{ 7, 14, 2, 10, 11, 16, 20, 50, 100, 200, 1000 } 중 ");
        System.out.print("검색할 데이터를 입력하세요: ");
        Scanner input = new Scanner(System.in);
        int search = Integer.parseInt(input.nextLine().trim());
        int result = sequentialSearch(arr, search);

        if(result == -1)
            System.out.println("데이터를 찾지 못하였습니다");
        else
            System.out.println("데이터의 index: " + result);

        input.close();
    }



}
