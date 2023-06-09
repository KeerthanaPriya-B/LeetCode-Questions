//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        
        //brute force approach - TC: O(N^2) SC: O(k->no.of windows)
		//refer Striver's DSA sheet written code & explanation for brute force 
		
		//refer - 15th june Queue 2 (time 3:00:00)
        
        //TC: O(N)  SC: O(k)
        ArrayList <Integer> res = new ArrayList <>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            while(!dq.isEmpty() && dq.getFirst() <= i-k)
                dq.removeFirst();
                
            while(!dq.isEmpty() && arr[dq.getLast()] < arr[i])
                dq.removeLast();
            
            dq.addLast(i);
            
            if(i >= k-1)
                res.add(arr[dq.getFirst()]);
        }
        return res;
    }
}