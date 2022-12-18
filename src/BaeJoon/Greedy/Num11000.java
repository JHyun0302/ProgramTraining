package BaeJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num11000 {

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        // 시작 시간을 기준으로 오름차순 정렬, 시간 같으면 종료시간 빠른거 앞으로
        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        //종료시간을 우선순위 큐에 넣음
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for(int i =1; i<N; i++){
            // 종료시간 기장 빠른것 <= 현재 시간
            if(pq.peek() <= lectures[i].start){
                pq.poll(); // 종료시간 빼기
            }
            pq.offer(lectures[i].end);
        }

        // 큐에 남은 개수 = 필요한 강의실 개수
        System.out.println(pq.size() + "\n");
    }
}
