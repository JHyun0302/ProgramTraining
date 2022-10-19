package Middle_Test_Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int weight, start, dest;
    Edge(int start, int dest, int weight){
        this.start = start;
        this.dest = dest;
        this.weight = weight;
    }

}

public class Longest_Time_Path {
    static int node;
    static int edge;
    static int start;
    static int weight;



    public static void longest_time_graph(){

    }

    class Graph
    {
        // 인접 목록을 나타내는 목록 목록
        List<List<Node>> adjList = new ArrayList<>();

        // 그래프를 생성하는 생성자
        public Graph(List<Edge> edges)
        {
            // 번호가 매겨진 최대 정점을 찾습니다.
            int n = 0;
            for (Edge e: edges) {
                n = Integer.max(n, Integer.max(e.src, e.dest));
            }

            // 인접 목록에 대한 메모리 할당
            for (int i = 0; i <= n; i++) {
                adjList.add(i, new ArrayList<>());
            }

            // 방향 그래프에 간선 추가
            for (Edge e: edges)
            {
                // 인접 목록의 새 노드를 src에서 dest로 할당합니다.
                adjList.get(e.src).add(new Node(e.dest, e.weight));

                // 무방향 그래프의 경우 라인 아래 주석 제거

                // dest에서 src로 인접 목록의 새 노드를 할당합니다.
                // adjList.get(e.dest).add(new Node(e.src, e.weight));
            }
        }
    public static void main(String[] args) {
        node = 4;
        edge = 3;
        start = 2;

        List<Edge> edges = Arrays.asList(new Edge(2, 1,1), new Edge(2, 3,1),
                new Edge(3, 4,1));
        Graph graph = new Graph(edges);


    }
}
