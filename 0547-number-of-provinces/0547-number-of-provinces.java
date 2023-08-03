class Solution {
    public void bfs(int n, List<List<Integer>> adj, boolean[] vis) {
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
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) 
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && isConnected[i][j] == 1) {
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
}












