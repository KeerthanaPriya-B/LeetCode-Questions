//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    // ******************* pathVis[] & DFS ****************************************
    
    // public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
    //     vis[node] = 1;
    //     pathVis[node] = 1;
        
    //     for(int neighbour: adj.get(node)) {
    //         if(vis[neighbour] == 0) {
    //             if(dfs(neighbour, adj, vis, pathVis))
    //                 return true;
    //         }
    //         else if(pathVis[neighbour] == 1)
    //             return true;
    //     }
    //     pathVis[node] = 0;
    //     return false;
    // }
    
    // // Function to detect cycle in a directed graph.
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
    //     int[] vis = new int[V];
    //     int[] pathVis = new int[V];
        
    //     for(int i=0; i<V; i++) {
    //         if(vis[i] == 0) {
    //             if(dfs(i, adj, vis, pathVis) == true)
    //                 return true;
    //         }
    //     }
    //     return false;
    // }
    
    //*********************** topological sort **********************************
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    
        Queue<Integer> q = new ArrayDeque<>();
        int[] INdegree = new int[V];
        //int[] topo = new int[V];
        
        for(int i=0; i<V; i++) {
            for(int edge: adj.get(i))
                INdegree[edge]++;
        }
        
        for(int i=0; i<V; i++) {
            if(INdegree[i] == 0)
                q.add(i);
        }
        
        int ind = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            cnt++;
            //topo[ind++] = node;
            
            for(int edge: adj.get(node)) {
                INdegree[edge]--;
                if(INdegree[edge] == 0)  q.add(edge);
            }
        }
        
        //topological sort is applicable only on directed Acyclic graph
        //so, if the cnt is equla to V, which means topo sort is applied succesfully
        //on the graph - so the graph should be the Acyclic -> return false, else true
        if(cnt == V) return false;
        return true;
    }
}


















