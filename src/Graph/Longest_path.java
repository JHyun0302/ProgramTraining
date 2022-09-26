package Graph;

import java.util.Arrays;
import java.util.Comparator;
public class Longest_path {
    static int MAX_VERTICES = 7;
    public static void union(int[] parent, int a, int b) { //a & b 노드 연결
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent) // 부모가 작은 쪽으로 합체
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    public static int find(int[] parent, int i) { // 사이클 여부 조사
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        int [][]graph = {{1, 2, 6}, {1, 3, 3}, {1, 4, 1}, {2, 5, 4}, {2,7,10}, {3, 4, 2}, {3, 5, 5}, {3,6,8}, {3,7,8}, {4, 5, 7},{5,6,4}}; // ex)1->2까지 cost:6
        int[] parent = new int[MAX_VERTICES + 1]; // 사이클 생성 여부}
        int total = 0; //가중치 총 합

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        Arrays.sort(graph, new Comparator<int[]>() { // cost 기준으로 내림차순 정렬
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                total += graph[i][2]; // cost 더하기
                union(parent, graph[i][0], graph[i][1]); //부모 합치기
                System.out.println("방문한 노드: " + graph[i][0] + " & " + graph[i][1] + ", " + "가중치: " + graph[i][2]);
            }
        }
        System.out.println("\n최소 비용 신장 트리 가중치의 합은 " + total);
    }
}

//annotation