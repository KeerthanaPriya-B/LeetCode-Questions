//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int K)
    {
        // code here 
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        ArrayList<Integer> al = new ArrayList<>();
 
        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < K; i++)
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
 
        // Print count of first window
        al.add(hM.size());
 
        // Traverse through the remaining array
        for (int i = K; i < arr.length; i++) {
 
            // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - K]) == 1) {
                hM.remove(arr[i - K]);
            }
 
            else // reduce count of the removed element
                hM.put(arr[i - K], hM.get(arr[i - K]) - 1);
 
            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
 
            // Print count of current window
            al.add(hM.size());
        }
        return al;
    }
}

