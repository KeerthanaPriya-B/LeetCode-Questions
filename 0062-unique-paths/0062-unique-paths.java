class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        countPaths(0,0,m,n,dp);
        return dp[0][0];
    }
    
    public int countPaths(int i,int j,int n,int m, int[][] dp) {
        if(i == n-1 && j == m -1) return 1;
        if(i >= n || j >= m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j] = countPaths(i, j+1, n, m, dp) + countPaths(i+1, j,n ,m, dp);
        return dp[i][j];
    }
}