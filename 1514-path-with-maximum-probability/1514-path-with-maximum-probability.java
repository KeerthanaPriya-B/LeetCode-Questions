class Solution {
    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            
            graph.get(a).add(new Pair(b, p));
            graph.get(b).add(new Pair(a, p));
        }

        double[] dis = new double[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->                                                                                  Double.compare(b.prob, a.prob));
        
        dis[start_node] = 1.0;
        pq.offer(new Pair(start_node, 1.0));

        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            for (Pair edge : graph.get(pair.node)) {
                double newprob = edge.prob * pair.prob;
                
                if(newprob > dis[edge.node]) {
                     dis[edge.node] = newprob;
                     pq.add(new Pair(edge.node, newprob));
                }
            }
        }
        return dis[end_node];
    }
}