//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
      
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = false;
            } }
            
        if(m[0][0] == 1)
            path(0, 0, "", m, n, ans, visited, di, dj);
        
        return ans;
    }
    
    static void path(int i, int j, String moves, int[][] m, int n, ArrayList<String> ans, boolean[][] visited, int[] di, int[] dj){
        
        if(i==n-1 && j==n-1){
            ans.add(moves);
            return;
        }
        
        String dir = "DLRU";
        for(int ind=0; ind<4; ind++)
        {
            int next_i = i + di[ind];
            int next_j = j + dj[ind];
            
            if(next_i>=0 && next_i<n && next_j>=0 && next_j<n && !visited[next_i][next_j] && m[next_i][next_j]==1)
            {
                visited[i][j] = true;
                path(next_i, next_j, moves+dir.charAt(ind), m, n, ans, visited, di, dj);
                visited[i][j] = false;
            }
        }
        
    }
}