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
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        int[][] res = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int[] rowarr = {-1, 0, 1, 0};
        int[] colarr = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            for(int i=0; i<4; i++) {
                int row = rowarr[i] + pair.r;
                int col = colarr[i] + pair.c;
                
                if(row>=0 && row<n && col>=0 && col<m && !vis[row][col]) {
                    vis[row][col] = true;
                    res[row][col] = pair.dis + 1;
                    q.add(new Pair(row, col, pair.dis + 1));
                }
            }
        }
        return res; 
    }
}












