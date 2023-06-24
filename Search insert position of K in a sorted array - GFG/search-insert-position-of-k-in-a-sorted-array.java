//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int N, int k)
    {
        // code here
        int low = 0, high = N-1, ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        if(ans == -1) return N;
        return ans;
    }
}