package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num841 {
/*    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        dfs(visited, rooms, 0);

        if(visited.size() == rooms.size())
            return true;
        return false;
    }

    public static void dfs(List<Integer> visited, List<List<Integer>> rooms, int start){
        visited.add(start);
        List<Integer> list = rooms.get(start);
        for (int i : list){
            if (!visited.contains(i))
                dfs(visited, rooms, i);
        }
    }*/

    /*public static void main(String[] args) {
        List<List<Character>> rooms = new ArrayList<>();
        rooms.add(Collections.singletonList(('1')));
        rooms.add(Collections.singletonList(('2')));
        rooms.add(Collections.singletonList(('3')));
        rooms.add(Collections.singletonList((' ')));

        System.out.println(rooms);
        List<List<Integer>> room_list = new ArrayList<>();
        room_list.add(rooms.get(0));
        rooms.get(1);
        rooms.get(2);
        rooms.get(3);
        System.out.println(rooms.get(0));
        //canVisitAllRooms();
    }*/

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        dfs(visited, rooms, 0);

        if(visited.size() == rooms.size())
            return true;
        return false;
    }
    public void dfs(List<Integer> visited, List<List<Integer>>rooms, int start){
        visited.add(start);
        List<Integer> list = rooms.get(start);
        for(int i : list){
            if(!visited.contains(i))
                dfs(visited, rooms, i);
        }
    }
}

