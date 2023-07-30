class Solution {
    class Pair{
        int r;
        int c;
        int time;
        Pair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        int freshCnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1) freshCnt++;
            }
        }
        
        int[] rowArr = {-1, 0, 1, 0};
        int[] colArr = {0, 1, 0, -1};
        int t = 0, cnt = 0;
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            for(int i=0; i<4; i++) {
                int row = rowArr[i] + pair.r;
                int col = colArr[i] + pair.c;
                
                if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && grid[row][col] == 1) {
                    vis[row][col] = true;
                    t = pair.time+1;
                    q.add(new Pair(row, col, t));
                   
                    cnt++;
                }
            }
        }
        
        if(freshCnt != cnt) return -1;
        return t;
    }
}










