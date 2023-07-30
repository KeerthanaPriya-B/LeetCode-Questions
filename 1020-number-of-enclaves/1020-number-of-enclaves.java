class Solution {
    public void dfs(int r, int c, int[][] grid, boolean[][] vis, int[] rowarr, int[] colarr, int n, int m) {
        
        vis[r][c] = true;
        
        for(int i=0; i<4; i++) {
            int row = rowarr[i] + r;
            int col = colarr[i] + c;
            
            if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && grid[row][col] == 1)
                dfs(row, col, grid, vis, rowarr, colarr, n, m);
        }
    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int[] rowarr = {-1, 0, 1, 0};
        int[] colarr = {0, 1, 0, -1};
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j] == 1 && !vis[i][j])
                    dfs(i, j, grid, vis, rowarr, colarr, n, m);
            }
        }
        
        int cnt = 0;
        for(int i=0; i<n; i++) {
           for(int j=0; j<m; j++) {
               if(grid[i][j] == 1 && !vis[i][j]) cnt++;
           }
        }
        return cnt;
    }
}







