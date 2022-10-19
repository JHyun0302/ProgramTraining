package Middle_Test_Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Can_Go_City {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visit;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int [N+1];
        for(int  i =0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i =0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        for(int i = 1; i <graph.size(); i++) {
            Collections.sort(graph.get(i));
            // Collections.sort(graph.get(i), Comparator.reverseOrder()); 24480은 위 코드를 안쓰고 이 코드를 쓰면 됨
        }

        DFS(R);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <visit.length;i++)
            sb.append(visit[i] + "\n");
        System.out.println(sb);

    }
    static void DFS(int start) {
        visit[start] = cnt;
        for(int i = 0; i<graph.get(start).size();i++) {
            int next = graph.get(start).get(i);
            if(visit[next] == 0) {
                cnt++;
                DFS(next);
            }
        }
    }

}

/* input값
10 10 0
7 8
5 9
9 8
5 2
6 4
1 8
0 5
4 6
0 2
1 4*/

