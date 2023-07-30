class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int[] rowarr = {-1, 0, 1, 0};
        int[] colarr = {0, 1, 0, -1};
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && 
                   board[i][j] == 'O' && !vis[i][j]){
                    //vis[i][j] = true;
                    dfs(i, j, board, vis, rowarr, colarr, n, m);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && board[i][j] == 'O')  board[i][j] = 'X';
            }
        }
        
    }
    
    public void dfs(int r, int c, char[][] board, boolean[][] vis, int[] rowarr, int[] colarr, int n, int m) {
        
        vis[r][c] = true;
        
        for(int i=0; i<4; i++) {
            int row = rowarr[i] + r;
            int col = colarr[i] + c;
            
            if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && board[row][col] == 'O')
                dfs(row, col, board, vis, rowarr, colarr, n, m);
        }
    }
}










