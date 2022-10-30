package Leetcode.Greedy;

import java.util.Arrays;

public class Num807 {
    /*public int maxIncreaseKeepingSkyline(int[][] grid) {
        int i, j;
        int[] row_max = new int[grid.length];
        int[] col_max = new int[grid[0].length];
        int max = Integer.MIN_VALUE;

        for(i =0; i< row_max.length; i++){
            max = Integer.MIN_VALUE;
            for(j=0; j<col_max.length; j++){
                if(max < grid[i][j]){
                    max = grid[i][j];
                    col_max[i] = max;
                }
                if(max < grid[j][i]){
                    max = grid[j][i];
                    row_max[i] = max;
                }
            }
        }
    }*/

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int i, j;
        int[] row_max = new int[grid.length];
        int[] col_max = new int[grid[0].length];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int output = 0;
        /*int[][] row = new int[grid.length][grid[0].length];
        int[][] col = new int[grid.length][grid[0].length];*/
        int[][] answer = new int[grid.length][grid[0].length];
        int[][] idx_row = new int[grid.length][2];
        int[][] idx_col = new int[grid.length][2];

/*        for(i =0; i< row_max.length; i++){
            for(j=0; j<col_max.length; j++) {
                row[i][j] = grid[i][j];
                col[i][j] = grid[i][j];
            }
        }*/
        for(i =0; i< row_max.length; i++){
            max1 = Integer.MIN_VALUE;
            max2 = Integer.MIN_VALUE;
            for(j=0; j<col_max.length; j++){
                if(max1 < grid[i][j]){
                    max1 = grid[i][j];
                    col_max[i] = max1;
                    /*idx_col[i][0] = i;
                    idx_col[i][1] = j;*/
                }
                if(max2 < grid[j][i]){
                    max2 = grid[j][i];
                    row_max[i] = max2;
                    /*idx_row[i][0] = j;
                    idx_row[i][1] = i;*/
                }
            }
        }
        //Arrays.sort(row_max);

        /*for(i =0; i< idx_row.length; i++){
            for(j=0; j<idx_row[0].length; j++) {
                System.out.print(idx_row[i][j] + " ");
            }
        }
        System.out.println();
        for(i =0; i< idx_col.length; i++){
            for(j=0; j<idx_col[0].length; j++) {
                System.out.print(idx_col[i][j]+ " ");
            }
        }*/

        for(i =0; i<answer.length;i++) {
            for(j = 0; j< answer[0].length;j++) {
                if(row_max[j] > col_max[i])
                    answer[i][j] = col_max[i];
                else
                    answer[i][j] = row_max[j];
            }
        }

        for(i =0; i<answer.length;i++) {
            for(j = 0; j< answer[0].length;j++)
                output += answer[i][j] - grid[i][j];
        }
        System.out.println();
/*        for(i =0; i< row_max.length; i++) {
            System.out.print(row_max[i] + " ");
        }
        System.out.println();
        for(i =0; i< col_max.length; i++) {
            System.out.print(col_max[i]+ " ");
        }*/
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        int output;
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        output = maxIncreaseKeepingSkyline(grid);
    }
}
