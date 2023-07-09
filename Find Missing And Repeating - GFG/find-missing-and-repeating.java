//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int nums[], int n) {
        // code here
        
        int[] res = new int[2];
	
		Arrays.sort(nums);
		
		for(int i=0; i<n-1; i++) {
			if(nums[i] == nums[i+1]) {
				res[0] = nums[i];
				break;
			}
		}
		int originalSum = 0, actualSum = 0;
		
		for(int i=0; i<n; i++) {
			originalSum += (i+1);
			actualSum += nums[i];
		}
		actualSum -= res[0];
		res[1] = originalSum - actualSum;
		
		return res;
    }
}