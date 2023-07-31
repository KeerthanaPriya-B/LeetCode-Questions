class Solution {
    class Pair{
        int r;
        int c;
        int dis;
        Pair(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;
        
        int n = grid.length;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0, 1));
        
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            if(pair.r == n-1 && pair.c == n-1) return pair.dis;
            
            for(int row=-1; row<=1; row++) {
                for(int col=-1; col<=1; col++) {
                    int r = row + pair.r;
                    int c = col + pair.c;
                    
                    if(r>=0 && r<n && c>=0 && c<n && grid[r][c] == 0 && !vis[r][c]) {
                        vis[r][c] = true;
                        q.add(new Pair(r, c, pair.dis+1));
                    }
                }
            }
        }
        return -1;
    }
}