//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    void dfs(int r, int c, boolean[][] vis, int[][] grid, ArrayList<String> al, int baserow, int basecol, int n, int m) {
        
        vis[r][c] = true;
        al.add(toString(baserow-r, basecol-c));
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1};
        
        for(int i = 0;i<4;i++) {
            int nrow = r + delrow[i];
            int ncol = c + delcol[i]; 
            // check for valid coordinates and for land cell
            if(nrow >=0 && nrow <n && ncol >=0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, al, baserow, basecol, n, m); 
            }
        }
    }
    
    String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> al = new ArrayList<>();
                    dfs(i, j, vis, grid, al, i, j, n, m);
                    set.add(al);
                }
            }
        }
        
        return set.size();
    }
}
