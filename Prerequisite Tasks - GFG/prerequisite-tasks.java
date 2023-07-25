//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
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
        if(cnt == V) return true;
        return false;
    }
    
}