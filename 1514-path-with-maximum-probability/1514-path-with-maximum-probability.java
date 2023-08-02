class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            double p = succProb[i];
            graph.get(a).add(new Pair<>(b, p));
            graph.get(b).add(new Pair<>(a, p));
        }

        // Step 2: Initialize the distance array and priority queue
        double[] distances = new double[n];
        Arrays.fill(distances, 0);
        distances[start_node] = 1.0;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        pq.offer(new Pair<>(start_node, 1.0));

        // Step 4: Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair<Integer, Double> curr = pq.poll();
            int node = curr.getKey();
            double prob = curr.getValue();

            // Skip if the current probability is smaller than the stored probability for this node
            // if (prob < distances[node]) {
            //     continue;
            // }

            // Explore neighboring nodes
            for (Pair<Integer, Double> edge : graph.get(node)) {
                int nextNode = edge.getKey();
                double nextProb = edge.getValue();
                double newProb = prob * nextProb;

                // If the new probability is greater, update the distance array and add the node to the priority queue
                if (newProb > distances[nextNode]) {
                    distances[nextNode] = newProb;
                    pq.offer(new Pair<>(nextNode, newProb));
                }
            }
        }

        // Step 6: Return the probability stored in the distance array for the end node
        return distances[end_node];
    }
}