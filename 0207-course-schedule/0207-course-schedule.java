class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int r = prerequisites.length;
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        for(int i=0; i<r; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            
            adj.get(u).add(v);
            
        }
        for(ArrayList<Integer> arr: adj) {
            for(int i: arr) {
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        int topo = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            topo++;
            
            for(int edge: adj.get(node)) {
                indegree[edge]--;
                if(indegree[edge] == 0) q.add(edge);
            }
        }
        if(n == topo) return true;
        return false;
    }
}