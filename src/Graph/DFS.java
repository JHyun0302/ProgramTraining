package Graph;

public class DFS {
    //각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
    public static boolean [] visited = {false, false, false ,false ,false ,false ,false ,false, false};
    // 인덱스가 각각의 노드번호! 따라서 0번 노드는 없으므로 비어진 상태이며 각 노드들과 연결된 노드를 보여줌
    public static int[][] graph = {{},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};

    public static void main(String[] args){
        int start = 1; // 시작 노드
        dfs(start);
    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for (int i : graph[v]){
            if (visited[i]==false)
                dfs(i);
        }
    }
}