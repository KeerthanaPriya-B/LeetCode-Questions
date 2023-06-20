//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] A, int n) {
        // code here
        
        //recording: 19th june Binary search 2 time(2:30:00)
		//TC: O(log n)  SC: O(1)
		
		
        int start = 0, end = A.length;

		while(start <= end) {
			int mid = (start+end)/2;

			if(mid == 0) {  //cases like 4 3 2 1 and 1 2 3 4 
				if(A[mid] > A[mid+1])
					return A[mid];
				else
					//move right
					start = mid+1;
			}
			else if(mid == A.length-1) {  // cases like 1 2 3 4 and 4 3 2 1
				if(A[mid] > A[mid-1])
					return A[mid];
				else
					//move left
					end = mid-1;
			}
			else {
				if(A[mid-1] < A[mid] && A[mid] > A[mid+1])
					return A[mid];
				else if(A[mid-1] < A[mid])
					//increasing side
					//move towards right
					start = mid+1;
				else
					//decreasing side
					//move towards left
					end = mid-1;
			}
			
		}
		return -1;
    }
}