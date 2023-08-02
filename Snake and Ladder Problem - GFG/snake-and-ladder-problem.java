//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
        Map<Integer, Integer> board = new HashMap<>();
        for (int i = 0; i < 2 * N; i += 2) {
            board.put(arr[i], arr[i + 1]);
        }

        // Perform BFS to find the shortest path from the source to the destination
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[31];
        queue.offer(1); // Start from the source cell
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int currentCell = queue.poll();

                if (currentCell == 30) {
                    return moves;
                }

                for (int j = 1; j <= 6; j++) {
                    int nextCell = currentCell + j;
                    if (nextCell <= 30 && !visited[nextCell]) {
                        visited[nextCell] = true;
                        if (board.containsKey(nextCell)) {
                            nextCell = board.get(nextCell);
                        }
                        queue.offer(nextCell);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}