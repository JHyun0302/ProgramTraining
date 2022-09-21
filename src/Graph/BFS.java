package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static boolean[] visited = new boolean[graph.length];
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.print("방문순서: ");
        bfs(1);
        System.out.println(sb);
    }

    public static void bfs(int n){
        q.offer(n); //enqueue
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll(); // dequeue
            sb.append(x).append(" ");

            for (int y : graph[x]) {
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}