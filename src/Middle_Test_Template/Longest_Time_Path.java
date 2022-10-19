package Middle_Test_Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.*;


class Edge <W,V>{
    private W weight;
    private V v;

    public void set_Edge(W weight, V v){
        this.weight = weight;
        this.v = v;
    }

}

public class Longest_Time_Path {
    static int node;
    static int edge;
    static int start_node;
    static boolean visited[];
/*    public static void dfs(Edge start_node, int longest_time_path){
        if()
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int longest_time_path = 0;
        ArrayList<Edge> ad = new <Edge>ArrayList();
        Edge<Integer, Integer> ed = new <Integer, Integer>Edge();

        for (int i = 0; i < n; i++) { // 총 2번 입력
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            start_node = Integer.parseInt(st.nextToken());
            for (int k = 0; k < node; k++)
                ad.add(new <Integer, Integer>Edge());

            for (int j = 0; j < edge; j++) { //edge 개수만큼 리스트 입력
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                ad.get(start).set_Edge(end, weight); //한 방향 연결
            } //가중치 그래프 연결 끝!

            //dfs(ad.get(start_node), longest_time_path);
        }

    }

}

