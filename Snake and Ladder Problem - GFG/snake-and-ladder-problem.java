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

class Solution {
    static int minThrow(int N, int[] arr) {
        // Create a HashMap to store the mapping of snakes and ladders
        Map<Integer, Integer> board = new HashMap<>();
        for (int i = 0; i < arr.length; i += 2) {
            board.put(arr[i], arr[i + 1]);
        }

        // Create a Queue for BFS
        Queue<int[]> queue = new LinkedList<>(); // (current cell, number of throws)
        queue.offer(new int[]{1, 0});

        // Create a Set to keep track of visited cells
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCell = current[0];
            int numThrows = current[1];

            if (currentCell == 30) {
                return numThrows;
            }
            
            for (int dice = 1; dice <= 6; dice++) {
                int nextCell = currentCell + dice;
                if (board.containsKey(nextCell)) {
                    nextCell = board.get(nextCell);
                }

                if (nextCell <= 30 && !visited.contains(nextCell)) {
                    queue.offer(new int[]{nextCell, numThrows + 1});
                    visited.add(nextCell);
                }
            }
        }

        return -1; // If it is not possible to reach the destination
    }
}












