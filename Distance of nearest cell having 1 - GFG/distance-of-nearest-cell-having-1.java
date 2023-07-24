//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair {
        int row;
        int col;
        int dis;
        Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int rowArr[] = {-1, 0, +1, 0};
        int colArr[] = {0, +1, 0, -1};
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            ans[pair.row][pair.col] = pair.dis;
            
            for(int i=0; i<4; i++) {
                int r = rowArr[i] + pair.row;
                int c = colArr[i] + pair.col;
                
                if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == 0 && !vis[r][c]) {
                    vis[r][c] = true;
                    q.add(new Pair(r, c, pair.dis+1));
                }
            }
        }
        return ans;
    }
}