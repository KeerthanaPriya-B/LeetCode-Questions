//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int vertex;
        int wgt;
        Pair(int vertex, int wgt) {
            this.vertex = vertex;
            this.wgt = wgt;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<N; i++) {
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0; i<M; i++) {
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		int[] dis = new int[N];
        for(int i=0; i<N; i++)  dis[i] = Integer.MAX_VALUE;
        dis[0] = 0;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            int parent = pair.vertex;
            
            for(Pair edge: adj.get(parent)) {
                int child = edge.vertex;
                int wgt = edge.wgt;
                
                if(dis[parent] + wgt < dis[child]) {
                    dis[child] = dis[parent] + wgt;
                    q.add(new Pair(child, dis[parent] + wgt));
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }
        return dis;
	}
}