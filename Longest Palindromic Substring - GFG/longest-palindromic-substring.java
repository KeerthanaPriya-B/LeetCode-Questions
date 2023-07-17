//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        // code here
        
        int n = s.length();
        if(n == 1)  return s;
        
        String LPS = "";
        
        for(int i=1; i<n; i++) {
            //odd length
            int low = i;
            int high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low == -1 || high == n)  break;
            }
            
            String palin = s.substring(low+1, high);
            if(palin.length() > LPS.length()) {
                if(palin.length() == 1)  
                    LPS = String.valueOf(s.charAt(0));
                else
                    LPS = palin;
            }
            //LPS = (palin.length() > LPS.length()) ? palin : LPS;
            
            
            //even length
            low = i-1;
            high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low == -1 || high == n)  break;
            }
            
            palin = s.substring(low+1, high);
            LPS = (palin.length() > LPS.length()) ? palin : LPS;
        }
        return LPS;
    }
}