//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        
        int lb = arr[0], rb = arr[n-1], left = 1, right = n-2;
		 long waterAmt = 0, heightOfBlock = 0;

		while(left <= right){
			if(lb <= rb){
				heightOfBlock = lb;
				
				if(heightOfBlock > arr[left]) 
					waterAmt += heightOfBlock - arr[left];
				else
					lb = Math.max(lb, arr[left]);
				
				left++;
			} 
			else {
				heightOfBlock = rb;
				
				if(heightOfBlock > arr[right]) 
					waterAmt += heightOfBlock - arr[right];
				else
					rb = Math.max(rb, arr[right]);
				
				right--;
			}
		}
	    return waterAmt;

    } 
}


