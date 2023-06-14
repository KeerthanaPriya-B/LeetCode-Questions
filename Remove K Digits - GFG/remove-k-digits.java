//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String num, int k) {
        // code here
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<num.length(); i++)
        {
            char n = num.charAt(i); 
            //if the peek ele is greater than the curr ele pop it,
            //since MSD has weightage, we are traversing form 0 to n and
            //also we are popping the peek ele when it is greater than the curr ele
            while(!s.isEmpty() && k > 0 && s.peek() > n) {
                s.pop();
                k--;
            }
            //to avoid leading zeros,
            if(s.isEmpty() && n=='0') 
                continue;
            else  
                s.push(n);
        }
           
        //if the string has numbers in ascending order, then it is not
        //possible pop any elements,for such cases we need to pop last ele
        while(!s.isEmpty() && k > 0){
            s.pop();
            k--;   
        }
        
        if(s.isEmpty()) 
            return "0";
        
        StringBuilder sb = new StringBuilder();
         while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        
        return sb.toString();
    }
}