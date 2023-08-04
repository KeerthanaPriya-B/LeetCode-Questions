//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int k) {
        // your code here
        
        //exactly k odd = atmost k odds - atmost k-1 odds
        return cntSubArr(S, k) - cntSubArr(S, k-1);
    }
    
    long cntSubArr (String S, int k) {
        int n = S.length();
        int[] freq = new int[26];
        
        int si = 0;
        int ei = 0;
        int distinct = 0;
        long cnt = 0;
        
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
            
            //update cnt of subArr
            cnt += ei-si+1;
            
            //expand window
            ei++;
        }
        return cnt;
    }
}








