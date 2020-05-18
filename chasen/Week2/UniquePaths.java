package com.chasen.p61to70;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if(i == 0 && j==0)
                    continue;
                dp[i][j] = (i-1 >= 0 ? dp[i-1][j] : 0) + (j-1 >= 0 ? dp[i][j-1] : 0);
            }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
