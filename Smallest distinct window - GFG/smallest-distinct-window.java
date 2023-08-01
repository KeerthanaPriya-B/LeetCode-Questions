//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        int n = str.length();
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            set.add(str.charAt(i));
        }
        
        int uniqueChars = set.size();
        
        int si = 0;
        int ei = 0;
        int minlen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(ei < n) {
            map.put(str.charAt(ei), map.getOrDefault(str.charAt(ei), 0)+1);
            
            while(map.size() == uniqueChars) {
                int len = ei - si + 1;
                minlen = Math.min(minlen, len);
                
                map.put(str.charAt(si), map.get(str.charAt(si))-1);
                if(map.get(str.charAt(si)) == 0)
                    map.remove(str.charAt(si));
                si++;
            }
            ei++;
        }
        // int len = ei - si + 1;
        // minlen = Math.min(minlen, len);
        return minlen;
    }
}








