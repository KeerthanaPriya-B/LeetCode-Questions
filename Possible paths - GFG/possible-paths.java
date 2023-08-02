//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] graph = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    graph[i][j] = Integer.parseInt(S[j]);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(S1[0]);
            int v = Integer.parseInt(S1[1]);
            int k = Integer.parseInt(S1[2]);
            Solution ob = new Solution();
            int ans = ob.MinimumWalk(graph, u, v, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Solution
// {
//     class Pair{
//         int node;
//         int des;
//         int dis;
//         Pair(int node, int des, int dis) {
//             this.node = node;
//             this.dis = dis;
//             this.des = des;
//         }
//     }
//     public int MinimumWalk(int[][] graph, int u, int v, int k)
//     {
//         // Code here
//         int n = graph.length;
        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i=0; i<n; i++)  adj.add(new ArrayList<>());
        
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 adj.get(i).add(j);
//             }
//         }
        
//         int cnt = 0;
//         boolean[] vis = new boolean[n];
//         Queue<Pair> q = new ArrayDeque<>();
//         q.add(new Pair(u, v, 0));
//         vis[u] = true;
        
//         while(!q.isEmpty()) {
//             Pair pair = q.remove();
            
//             if(pair.dis == k && pair.node == v) {
//                 cnt++;
//                 continue;
//             }
//             for(int edge: adj.get(pair.node)) {
//                 if(!vis[edge]) {
//                     vis[edge] = true;
//                     q.add(new Pair(edge, v, pair.dis+1));
//                 }
//             }
//         }
//         return cnt;
//     }
// }

class Solution {
    private static final int MOD = 1000000007;
    private int[][][] memo;
    
    public int MinimumWalk(int[][] graph, int u, int v, int k) {
        memo = new int[graph.length][graph.length][k+1];
        return countWalks(graph, u, v, k);
    }
    
    private int countWalks(int[][] graph, int u, int v, int k) {
        if (k == 0 && u == v) {
            return 1;
        }
        
        if (k <= 0) {
            return 0;
        }
        if(memo[u][v][k] != 0)
            return memo[u][v][k];
        
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] == 1) {
                count += countWalks(graph, i, v, k - 1);
                count %= MOD;
            }
        }
        memo[u][v][k] = count;
        return count;
    }
}
















