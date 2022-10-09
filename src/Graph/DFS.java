package Graph;

public class DFS {
    public static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}}; // index값 == 노드 번호, 배열 속 값 == 연결된 노드들
    public static boolean [] visited =  new boolean[graph.length];
    public static void main(String[] args){
        int start = 1; // 시작 노드
        System.out.print("DFS 방문순서: ");
        dfs(start);

    }

    public static void dfs(int n){
        visited[n] = true;
        System.out.print(n + " ");

        for (int i : graph[n]){
            if (visited[i]==false)
                dfs(i);
        }
    }
}