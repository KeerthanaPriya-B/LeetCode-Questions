//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    class Pair{
        int r;
        int c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 || j==0 || i==n-1 || j==m-1) {
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = true; 
                    }
                }
            }
        }
        
        int rowArr[] = {-1, 0, +1, 0};
        int colArr[] = {0, +1, +0, -1};
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            for(int i=0; i<4; i++) {
                int r = pair.r + rowArr[i];
                int c = pair.c + colArr[i];
                
                if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && grid[r][c] == 1) {
                    vis[r][c] = true;
                    q.add(new Pair(r, c));
                }
            }
        }
        
        int lands = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j] == 1)  lands++;
            }
        }
        return lands;
    }
}