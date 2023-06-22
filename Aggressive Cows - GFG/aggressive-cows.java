//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int cows, int[] stall) {
        
        
		//recording 20th june binary search 3(time- 2:00:00)
		//TC: O(N* logN)  SC: O(1)

		
		Arrays.sort(stall);
		int large = 0;

		//setting limits;
		int high = stall[n-1] - stall[0];
		int low = Integer.MAX_VALUE;

		//min distance b/w two consecutive stall
		for(int i=1; i<n; i++) {
			int dis = stall[i] - stall[i-1];
			low = Math.min(low, dis);
		}
		
		while(low <= high) {
			int mid = (low+high)/2;

			if(Ispossible(stall, mid, cows)) {
				large = mid;
				low = mid+1;
			} else
				high = mid-1;	
		}
		return large;
    }
	
	public static boolean Ispossible(int stall[], int dis, int cows){

		int cowCnt = 1, prevStall = stall[0];

		for(int i=1; i<stall.length; i++) {
			if(stall[i]-prevStall >= dis) {
				cowCnt++;
				prevStall = stall[i];
			}
		}
		return cowCnt >= cows;
	}
}