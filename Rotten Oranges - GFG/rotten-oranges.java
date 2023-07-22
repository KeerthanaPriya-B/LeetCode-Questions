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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        
        int freshCnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // if cell contains rotten orange
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));                    
                    // mark as visited (rotten) in visited arra
                    vis[i][j] = 2;
                }
                //counting no.of fresh oranges
                if(grid[i][j] == 1)  freshCnt++;
            }
        }
        
        // delta row and delta column
        int rowArr[] = {-1, 0, +1, 0};
        int colArr[] = {0, 1, 0, -1}; 
        
        int freshOrangesVis = 0;
        int tm = 0;
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            int row = pair.row;
            int col = pair.col;
            int time = pair.time;
            
            tm = Math.max(tm, time);
            // exactly 4 neighbours
            for(int i=0; i<4; i++) {
                int nrow = row + rowArr[i];
                int ncol = col + colArr[i];
                // check for valid coordinates and 
                // then for unvisited fresh orange
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                   grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                       
                        q.add(new Pair(nrow, ncol, time + 1));
                        //mark as rotten
                        vis[nrow][ncol] = 2;
                        freshOrangesVis++;
                   }
            }
        }
        
        if(freshOrangesVis != freshCnt)  return -1;
        return tm;
        
        
        
    }
}