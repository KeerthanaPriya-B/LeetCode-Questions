//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> isConnected, int n) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) 
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && isConnected.get(i).get(j) == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int cnt=0;
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                cnt++;
                bfs(i, adj, vis);
            }
        }
        return cnt;
    }
    
    static void bfs(int n, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        vis[n] = true;
        
        while(!q.isEmpty()) {
            int node = q.remove();
            
            for(int edge: adj.get(node)) {
                if(!vis[edge]) {
                    vis[edge] = true;
                    q.add(edge);}
            }
        }
    }
}