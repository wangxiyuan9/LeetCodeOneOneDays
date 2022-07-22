package com.wxy.day09;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/22 21:47
 */
public class Lt02 {
}

/*
step right/down
dp[i-1][j-1] : the path solutions for (0,0) to (i,j)
dp[1][1]=dp[1][0]+dp[1][0]
base case dp[i][0] and dp[0][j]=0
res=dp[m-1][n-1]
Array:dp[m][n]
 */
class Solution01 {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        int[][] dp = new int[m][n];
        //base case
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}