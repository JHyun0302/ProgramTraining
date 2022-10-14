package Leetcode;

public class Num207 {

    static int i, j;
    public static boolean canFinish(int numCourses, int[][] prerequisites, int[] visited, int[][] adj_mat) {
        int V = numCourses;
        for (i = 0; i < numCourses; i++)
            visited[i] = 0;
        for (i = 0; i < numCourses; i++) {
            for (j = 0; j < numCourses; j++) {
                adj_mat[i][j] = 0;
            }
        }

        for(i = 0; i< prerequisites.length; i++) {
            adj_mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        for(i =0; i<numCourses; i++){
            if(adj_mat[i][i] == 1)
                return false;
            for(j =0; j<numCourses; j++){
                if(adj_mat[i][j] == 1 && adj_mat[j][i] == 1){
                    return false;
                }
            }
        }
        if(has_cycle(numCourses-1, visited, adj_mat, V) == 1)
            return false;
        else
            return true;
    }
    public static int has_cycle(int n, int[] visited, int[][] adj_mat, int V) {
        int cycle = 0;
        if(visited[n] == 0){
            visited[n] = 1;
            for(i=0; i<V; i++){
                if(adj_mat[n][i] == 1){
                    if(has_cycle(i, visited, adj_mat, V) == 1)
                        return 1;
                }
            }
            visited[n] = 0;
            return 0;
        }
        else
            return 1;
    }

    public static void main(String[] args) {
        int numCourses = 2; //input
        int[] visited = new int[numCourses+1];
        int[][] adj_mat = new int[numCourses+1][numCourses+1];
        int[][] prerequisites = new int[numCourses+1][numCourses+1];
        for (i = 0; i < numCourses; i++)
            visited[i] = 0;
        for (i = 0; i < numCourses; i++) {
            for (j = 0; j < numCourses; j++) {
                adj_mat[i][j] = 0;
            }
        }
        canFinish(numCourses, prerequisites, visited, adj_mat); //prerequisites - input

    }
}
