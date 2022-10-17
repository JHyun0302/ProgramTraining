package Leetcode;

public class Num207 {

    static boolean[] visited;
    static int[][] adj_mat;
     public static boolean canFinish(int numCourses, int[][] prerequisites) {
         int i, j;
         for(i =0; i<prerequisites.length; i++){
             adj_mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
         }
         for(i=0; i<numCourses; i++){
             if(adj_mat[i][i] == 1)
                 return false;
             for(j =0; j<numCourses;j++){
                 if(adj_mat[i][j] == 1 && adj_mat[j][i] == 1)
                     return false;
             }
         }
        if(has_cycle(numCourses-1, numCourses))
            return false;
        else
            return true;
     }
     public  static boolean has_cycle(int n, int numCourses){
         int i;
         boolean bool;

         if(visited[n] == false){
             visited[n] = true;
             for(i =0; i<numCourses; i++){
                 if(adj_mat[n][i] == 1){
                     if(has_cycle(i,numCourses))
                         return true;
                 }
             }
             visited[n] = false;
             return false;
         }
         else
             return true;
     }
    public static void main(String[] args) {
         int i,j;
         int numCourses = 2;
         boolean res;
         int[][] prerequisites = new int[numCourses+1][numCourses+1];
         visited = new boolean[numCourses+1];
         adj_mat = new int[numCourses+1][numCourses+1];
         prerequisites[0][0] = 1;
         prerequisites[0][1] = 0;
         prerequisites[1][0] = 0;
         prerequisites[1][1] = 1;
         for(i=0; i< numCourses; i++){
             for(j =0; j<numCourses; j++)
                 adj_mat[i][j] = 0;
         }
         res = canFinish(numCourses, prerequisites);
        System.out.println("Result: "+res);
     }
}
