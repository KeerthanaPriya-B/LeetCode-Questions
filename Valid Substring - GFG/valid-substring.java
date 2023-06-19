//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        
        //Approach 1
        
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int cnt = 0, max = 0;
        
        for(int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            if(ch=='(')
                s.push(i);
            else {
                s.pop();
                if(!s.isEmpty())
                    max= Math.max(max, i-s.peek());
                else
                    s.push(i);
            } }
        return max;
        
         //Approach 2
         
        // for(int i=0; i<S.length(); i++) {
        //     char ch = S.charAt(i);
        //     if(ch=='(')
        //         s.push(i);
        //     else {
        //         if(!s.isEmpty() && S.charAt(s.peek()) == '(')
        //             s.pop();
        //         else
        //             s.push(i);
        //     }
        // }
        // int end = S.length();
        // while(!s.isEmpty()) {
        //     int start = s.pop();
        //     max = Math.max(max, end-start-1);
        //     end = start;
        // }
        // return Math.max(max, end);
        
    }
}