package Middle_Test_Template;

public class Count_Zero {
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) {
        arr= new int[9];
        arr[0] = 1;
        for(int i = 1; i<4; i++){
            arr[i*2-1] = 0;
            arr[i*2] = 1;
        }
        arr[7] = 0;
        //countzeros(0, cnt);
        System.out.println("cnt: " +  countzeros(0, cnt));
    }

    public static int countzeros(int start, int cnt) {
        if(arr.length-1 == start)
            return cnt;
        if(arr[start] == 0){
            return countzeros(start+1, cnt+1);
        }
    return countzeros(start+1, cnt);
    }
}
