//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String s[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int a[] = new int[n];
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(s[i]);
			List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
			for(List<Integer> list : ans){
				for(int x : list)
					ot.print(x + " ");
				ot.println();
			}
			if(ans.size() == 0)
			    ot.println();
		}
        ot.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	public List<List<Integer>> CombinationSum2(int a[], int n, int k){
		// Code Here.
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(a);
		combination(a, n, k, 0, new ArrayList<>(), res);
		return res;
	}
	
	static void combination(int a[], int n, int k, int ind, List<Integer> ans, List<List<Integer>> res){
	    
	    if(k==0){
	        res.add(new ArrayList(ans));
	        return;
	    }
	    
	    for(int i=ind; i<n; i++){
	        if(i!=ind && a[i]==a[i-1]) continue;
	        if(a[i]>k) return;
	        
	        ans.add(a[i]);
	        combination(a, n, k-a[i], i+1, ans, res);
	        ans.remove(ans.size()-1);
	    }
	}
}

