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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
//************************* using dfs **********************************
    
    public boolean detect(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        
        for(int neighbour: adj.get(node)) {
            if(!vis[neighbour]) {
                if(detect(neighbour, node, adj, vis))  
                    return true;
            }
            else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i])
                if(detect(i, -1, adj, vis))  return true;
        }
        return false;
    }
    
//************************* using bfs **********************************
    
    // class Pair {
    //     int vertex;
    //     int parent;
    //     Pair(int vertex, int parent) {
    //         this.vertex = vertex;
    //         this.parent = parent;
    //     }
    // }
    
    // public boolean detect(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
    //     vis[node] = true;
    //     Queue<Pair> q = new ArrayDeque<>();
    //     q.add(new Pair(node, -1));
        
    //     while(!q.isEmpty()) {
    //         Pair pair = q.remove();
            
    //         for(int neighbour: adj.get(pair.vertex)) {
    //             if(!vis[neighbour]) {
    //                 q.add(new Pair(neighbour, pair.vertex));
    //                 vis[neighbour] = true;
    //             }
    //             //if already visited node is not parent, we found cycle
    //             else if(neighbour != pair.parent){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    // // Function to detect cycle in an undirected graph.
    // public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // Code here
    //     boolean[] vis = new boolean[V];
        
    //     for(int i=0; i<V; i++) {
    //         if(!vis[i])
    //             if(detect(i, adj, vis))  return true;
    //     }
    //     return false;
    // }
}