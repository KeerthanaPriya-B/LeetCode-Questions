//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String S, int k) {
        // code here
        return cntSubArr(S, k);
    }
    
    public int cntSubArr (String S, int k) {
        int n = S.length();
        int[] freq = new int[26];
        
        int si = 0;
        int ei = 0;
        int distinct = 0;
        int maxlen = 0;
        
        while(ei < n) {
            char c = S.charAt(ei);
            freq[c - 'a']++;
            
            //if the char is occured for the 1st time, increase distinct
            if(freq[c - 'a'] == 1)  distinct++;
            
            while(distinct > k) {
                char ch = S.charAt(si);
                freq[ch - 'a']--;
                
                //if the char is no longer in the freq arr, decrease distinct
                if(freq[ch - 'a'] == 0)  distinct--;
                si++;
            }
            
            //update maxlen
            if(distinct == k) 
                maxlen = Math.max(maxlen, ei-si+1);
            
            //expand window
            ei++;
        }
        
        if(maxlen == 0) return -1;
        return maxlen;
    }
}