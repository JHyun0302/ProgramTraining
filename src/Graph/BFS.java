package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}}; // index값 == 노드 번호, 배열 속 값 == 연결된 노드들
    static boolean[] visited = new boolean[graph.length];
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder VisitOrder = new StringBuilder();

    public static void main(String[] args) {
        int start = 1;
        System.out.print("BFS 방문순서: ");
        bfs(start);
        System.out.println(VisitOrder);
    }

    public static void bfs(int n){
        queue.offer(n); //enqueue
        visited[n] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll(); // dequeue
            VisitOrder.append(x).append(" ");

            for (int i : graph[x]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i); // 방문하지 않은 노드 enqueue & true만듬
                }
            }
        }
    }
}