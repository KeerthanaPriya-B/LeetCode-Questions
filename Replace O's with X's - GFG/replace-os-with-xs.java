//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int r, int c, int n, int m, char a[][], boolean[][] vis) {
        vis[r][c] = true;
        
        int[] rowArr = {-1, 0, 1, 0};
        int[] colArr = {0, 1, 0, -1};
        
        for(int i=0; i<4; i++) {
            int row = r + rowArr[i];
            int col = c + colArr[i];
            
            if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && a[row][col] == 'O') {
                dfs(row, col, n, m, a, vis);
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0; i<m; i++) {
            if(a[0][i] == 'O' && !vis[0][i]) {
                dfs(0, i, n, m, a, vis);
            }
            if(a[n-1][i] == 'O' && !vis[n-1][i]) {
                dfs(n-1, i, n, m, a, vis);
            }
        }
        
        for(int i=0; i<n; i++) {
            if(a[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, n, m, a, vis);
            }
            if(a[i][m-1] == 'O' && !vis[i][m-1]) {
                dfs(i, m-1, n, m, a, vis);
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && a[i][j] == 'O') {
                    vis[i][j] = true;
                    a[i][j] = 'X';
                }
            }
        }
        return a;
        
    }
}