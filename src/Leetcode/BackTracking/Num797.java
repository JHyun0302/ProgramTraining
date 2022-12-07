package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};

        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        dfs(graph, 0, graph.length - 1, res, list);
        return res;
    }

    public static void dfs(int[][] graph, int source, int depth, List<List<Integer>> res, LinkedList<Integer> list) {
        if (depth == source) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int neighbor : graph[source]) {
            list.add(neighbor);
            dfs(graph, neighbor, depth, res, list);
            list.removeLast();
        }
    }
}
