package Leetcode.BackTracking;

import java.util.HashSet;
import java.util.Set;

public class Num1079 {
    static boolean visit[];

    public static int numTilePossibilities(String tiles) {
        visit = new boolean[tiles.length()];
        Set<String> set = new HashSet<>();
        backtrack(tiles, "", set);
        return set.size() - 1;
    }

    public static void backtrack(String tiles, String curr, Set<String> set) {
        set.add(curr);
        for (int i = 0; i < tiles.length(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                backtrack(tiles, curr + tiles.charAt(i), set);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        int result = numTilePossibilities(tiles);
        System.out.println(result);
    }
}
