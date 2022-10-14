package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Num684 {
    static int i, j;
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int[] e: edges) // 1개 행만 edges에서 추출
            if (find(parent, e[0]) == find(parent, e[1]))
                return e; //부모 합치기
            else
                union(parent, e[0], e[1]);
            return edges[0];

    }

    public static void union(int[] parent, int a, int b) { //a & b 노드 연결
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);
            parent[b_parent] = a_parent;
    }

    public static int find(int[] parent, int i) { // 사이클 여부 조사
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

}



