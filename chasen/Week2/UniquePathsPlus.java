package com.chasen.p61to70;

public class UniquePathsPlus {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // rows' length
        int n = obstacleGrid.length;
        // columns' length
        int m = obstacleGrid[0].length;
        // create dp array
        int [][] dp = new int[n][m];
        // set initial value
        if(obstacleGrid[0][0] != 1)
            dp[0][0] = 1;
        // set value in dp
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if(i == 0 && j==0)
                    continue;
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                // dp[i][j] = dp[i-1]dp[j] + dp[i][j-1]
                else
                    dp[i][j] = (i-1 >= 0 ? dp[i-1][j] : 0) + (j-1 >= 0 ? dp[i][j-1] : 0);

            }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
//        int [][] og = {{0,0,0},{0,1,0},{0,0,0}};
        int [][] og = {{1}};
        System.out.println(uniquePathsWithObstacles(og));
    }
}
