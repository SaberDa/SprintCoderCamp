package com.chasen.p61to70;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        // rows' length
        int R = grid.length;
        // columns' length
        int C = grid[0].length;
        // set value in gird to ensure the space size is O(1)
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++){
                if(i == 0 && j==0)
                    continue;
                else
                    grid[i][j] = Math.min((i-1 >= 0 ? grid[i-1][j] : Integer.MAX_VALUE),
                                            (j-1 >= 0 ? grid[i][j-1] : Integer.MAX_VALUE))
                                    + grid[i][j];

            }
        return grid[R-1][C-1];
    }

    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
