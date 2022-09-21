package Graph;

import java.util.ArrayList;
import java.util.Scanner;

/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */


class Node {
    int idx; //도착 지점
    int cost; //가는데 거리

    Node(int idx, int cost) { //생성자
        this.idx = idx;
        this.cost = cost;
    }
}

public class Shortest_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("node 개수: ");
        int V = sc.nextInt(); //노드 개수
        System.out.print("edge 개수: ");
        int E = sc.nextInt(); // 간선 개수
        System.out.print("start: ");
        int start = sc.nextInt();
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("그래프 넣기(a, b, cost)");
        for (int i = 0; i < E; i++) { // 그래프에 값 넣기
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt(); //a에서 b까지 가는데 cost

            graph.get(a).add(new Node(b, cost));
        }
        boolean[] visited = new boolean[V + 1]; // 방문 여부
        int[] dist = new int[V + 1]; // 최소 거리 저장

        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            // 인접 노드의 최소 거리 값을 갱신
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
        sc.close();
    }
}