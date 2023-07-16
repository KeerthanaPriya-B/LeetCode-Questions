//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int a[], int n) 
	{ 
        // code here
        
        long[] res = new long[n];
        long[] prefixProd = new long[n];
        long[] suffixProd = new long[n];
        
		prefixProd[0] = 1;
        for(int i=1; i<n; i++) {
            prefixProd[i] = a[i-1] * prefixProd[i-1];
        }
        
        suffixProd[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            suffixProd[i] = a[i+1] * suffixProd[i+1];
        }
        
		for(int i=0; i<n; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
		return res;
	} 
} 
