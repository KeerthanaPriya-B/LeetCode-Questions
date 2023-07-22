//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int row;
        int col;
        
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public void bfs(int r, int c, char[][] grid, boolean[][] vis) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        vis[r][c] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c));
        
        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            
            q.remove();
            
            for(int delrow = -1; delrow <= 1; delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = delrow + row;
                    int ncol = delcol + col;
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                       grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                           vis[nrow][ncol] = true;
                           q.add(new Pair(nrow, ncol));
                       }
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return cnt;
    }
    
    
}