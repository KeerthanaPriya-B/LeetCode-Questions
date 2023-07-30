class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) 
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                cnt++;
                dfs(i, vis,adj);
            }
                
        }
        return cnt;
    }
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for(int edge: adj.get(node)) {
            if(!vis[edge])
                dfs(edge, vis, adj);
        }
    }
}









