class Solution {
    public boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<graph.length; i++)
            adj.add(new ArrayList<>());
        
        int ind = 0;
        for(int[] arr: graph) {
            for(int i: arr) {
                adj.get(ind).add(i);
                adj.get(i).add(ind);
            }
            ind++;
        }
        
        return isbipartite(graph.length, adj);
    }
    
    public boolean check(int node, int COLOR, ArrayList<ArrayList<Integer>>adj, int[] color)     { 
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
    
    public boolean isbipartite(int V, ArrayList<ArrayList<Integer>>adj)
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