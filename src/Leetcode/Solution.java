package Leetcode;
class Solution {
    int[] visited = new int[numCourses];
        for(i = 0; i<numCourses; i++){
        visited[i] = 0;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i, j =0;
        int[][] adj_mat = new int[numCourses+1][numCourses+1];
        for(i = 0; i< numCourses; i++) {
            for (j = 0; j < numCourses; j++) {
                if(prerequisites[j][0] == i) {
                    adj_mat
                }
            }
        }

        for(i = 0; i< numCourses; i++) {
            for(j = 0; j< numCourses; j++) {

            }
        }



        //has_cycle(visited,numCourses, i, j);

    }
    int has_cycle( int numCourses, int i, int j) {
        int cycle = 0;
        if(visited[i] == 0){
            visited[i] = 1;
            for(i=0; i<numCourses; i++){
                if(adj_mat[numCourses][i] == 1){
                    if(has_cycle(i))
                        return 1;
                }
            }

            visited[n] = 0;
            return 0;
        }
        else
            return 1;
    }

}


