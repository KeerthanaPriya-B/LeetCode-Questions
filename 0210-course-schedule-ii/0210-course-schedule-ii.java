class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[n];
        
        int row = prerequisites.length;
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<row; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            
            adj.get(u).add(v);   
        }
        
        for(ArrayList<Integer> arr: adj) {
            for(int i: arr)
                indegree[i]++;
        }
        
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        int[] topo = new int[n];
        int ind = 0, cnt = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            topo[ind++] = node;
            cnt++;
            
            for(int edge: adj.get(node)) {
                indegree[edge]--;
                if(indegree[edge] == 0) q.add(edge);
            }
        }
        if(cnt == n)
            return topo;
        return new int[]{};
    }
}