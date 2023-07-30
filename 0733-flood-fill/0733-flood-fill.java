class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        
        int n = image.length;
        int m = image[0].length;
        int startPixel = image[sr][sc];
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr, sc));
        
        boolean[][] vis = new boolean[n][m];
        vis[sr][sc] = true;
        image[sr][sc] = color;
        
        int[] rowarr = {-1, 0, 1, 0};
        int[] colarr = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            for(int i=0; i<4; i++) {
                int row = rowarr[i] + pair.r;
                int col = colarr[i] + pair.c;
                
                if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && image[row][col] == startPixel) {
                    vis[row][col] = true;
                    image[row][col] = color;
                    q.add(new Pair(row, col));
                }
            }
        }
        return image;
    }
}