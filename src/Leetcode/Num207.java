package Leetcode;

public class Num207 {

    static int i, j;
    static int numCourses = 2;
    static int[] visited = new int[numCourses];

    static int[][] adj_mat = new int[numCourses][numCourses];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
 /*       for(i = 0; i< numCourses; i++) {
            for (j = 0; j < numCourses; j++) {
                if(prerequisites[i][j] == 1) {
                    adj_mat[i][j] = prerequisites[i][j]
                }
            }
        }*/

        for(i = 0; i< prerequisites.length; i++) {
            adj_mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        for(i =0; i<numCourses; i++){
            for(j =0; j<numCourses; j++){
                if(adj_mat[i][j] == 1 && adj_mat[j][i] == 1){
                    return false;
                }
            }
        }
        return true;
    }
/*    static int has_cycle( int n) {
        int cycle = 0;
        if(visited[i] == 0){
            visited[i] = 1;
            for(i=0; i<numCourses; i++){
                if(adj_mat[n][i] == 1){
                    if(has_cycle(i) == 1)
                        return 1;
                }
            }
            visited[n] = 0;
            return 0;
        }
        else
            return 1;
    }*/

    public static void main(String[] args) {
        for (i = 0; i < numCourses; i++)
            visited[i] = 0;
        for (i = 0; i < numCourses; i++) {
            for (j = 0; j < numCourses; j++) {
                adj_mat[i][j] = 0;
            }
        }

    }
}
