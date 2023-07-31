class Solution {
    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathvis, boolean[] check) {
        vis[node] = true;
        pathvis[node] = true;
        
        for(int edge: graph[node]) {
            if(!vis[edge]) {
                if(dfs(edge, graph, vis, pathvis, check)) return true;
            }
            else if(pathvis[edge]) return true;
        }
        pathvis[node] = false;
        check[node] = true;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        int n = graph.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
//         for(int i=0; i<n; i++)
//             adj.add(new ArrayList<>());
        
//         for(int i=0; i<n; i++) {
//             int u = graph[i][0];
//             int v = graph[i][1];
            
//             adj.get(u).add(v);   
//         }
        
        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];
        boolean[] check = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!vis[i])
                dfs(i, graph, vis, pathvis, check);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(check[i])
                res.add(i);
        }
        return res;
    }
}