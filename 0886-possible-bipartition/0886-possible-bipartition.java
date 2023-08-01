class Solution {
    public boolean dfs(int node, int COLOR,  ArrayList<ArrayList<Integer>> adj, int[] color)    {
        color[node] = COLOR;
        for(int edge: adj.get(node)) {
            if(color[edge] == -1) {
                if(! dfs(edge, 1-COLOR, adj, color))
                    return false;
            }
            else if(color[edge] == color[node])
                return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        
        int m = dislikes.length;
        for(int i=0; i<m; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[n+1];
        for(int i=1; i<=n; i++) color[i] = -1;
        
        for(int i=1; i<=n; i++) {
            if(color[i] == -1) {
                if(! dfs(i, 0, adj, color))
                    return false;
            }
        }
        return true;
    }
}