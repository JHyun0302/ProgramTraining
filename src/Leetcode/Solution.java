package Leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        dfs(visited, rooms, 0);

        if(visited.size() == rooms.size())
            return true;
        return false;
    }

    public void dfs(List<Integer> visited, List<List<Integer>> rooms, int start){
        visited.add(start);
        List<Integer> list = rooms.get(start);
        for (int i : list){
            if (!visited.contains(i))
                dfs(visited, rooms, i);
        }
    }
}