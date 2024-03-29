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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    //******************* BFS ***************************
    // public boolean check(int start, int V, ArrayList<ArrayList<Integer>>adj, int color[]) { 
        
    //     Queue<Integer> q = new LinkedList<>();
	   // q.add(start); 
	   // color[start] = 0;
	    
	   // while(!q.isEmpty()) {
	   //     int node = q.remove();
	        
	   //     for(int neighbour: adj.get(node)) {
	   //         if(color[neighbour] == -1) {
	   //             q.add(neighbour);
	   //             color[neighbour] = 1 - color[node];
	   //         }
	   //         else if(color[neighbour] == color[node])
	   //             return false;
	   //     }
	   // }
	   // return true;
    // }
    
    //******************* DFS ***************************
    public boolean check(int node, int COLOR, ArrayList<ArrayList<Integer>>adj, int[] color) {
        
        color[node] = COLOR;
        
        for(int neighbour: adj.get(node)) {
            if(color[neighbour] == -1) {
                if(check(neighbour, 1 - COLOR, adj, color) == false)
                    return false;
            }
            else if(color[neighbour] == color[node]) 
                return false;
        }
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[] = new int[V]; 
	    for(int i = 0;i<V;i++) color[i] = -1; 
	    
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            //dfs
	            if(check(i, 0, adj, color) == false)
	                return false;
	           //bfs
	           // if(check(i, V, adj, color) == false) {
	           //     return false; 
	           // }
	        }
	    }
	    return true;
    }
}