package Graph;

public class Shortest_path {
    static int INF = Integer.MAX_VALUE;
    static int MAX_VERTICES = 7;
    static int True = 1;
    static int False = 0;
    static int weight[][] = {
            {0, 7, INF, INF, 3, 10, INF},
            {7, 0, 4, 10, 2, 6, INF},
            {INF, 4, 0, 2, INF, INF, INF},
            {INF, 10, 2, 0, 11, 9, 4},
            {3, 2, INF, 11, 0, INF, 5},
            {10, 6, INF, 9, INF, 0, INF},
            {INF, INF, INF, 4, 5, INF, 0}};
    static int distance[] = new int[MAX_VERTICES];
    static int found[] = new int[MAX_VERTICES];

    public static  int choose(int distance[], int n, int found[]){
        int i, min, minpos;
        min = INF;
        minpos = -1;
        for(i = 0; i<n;i++)
            if(distance[i] < min && found[i] == 0){
                min = distance[i];
                minpos = i;
            }
        return minpos;
    }

    public static void dijkestra(int start, int n){
        int i,u,w;
        for(i = 0; i<n;i++){ // init
            distance[i] = weight[start][i];
            found[i] = False;
        }
        found[start] = True; // 시작 정점 방문
        distance[start] = 0;
        for(i = 0; i<n-1;i++){
            u = choose(distance,n,found);
            found[u] = True;
            System.out.print(u + " ");
            for(w=0;w<n;w++){
                if(found[w] == 0) // 아직 방문하지 않은 정점 중
                    if(distance[u] + weight[u][w] < distance[w]){ // 최단거리인 정점 찾기
                        distance[w] = distance[u] + weight[u][w];
                    }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("방문한 정점 순서: 0 ");
        dijkestra(0, MAX_VERTICES);

    }
}

