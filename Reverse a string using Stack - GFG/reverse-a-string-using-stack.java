//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        //code here
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        
        for(char ch: S.toCharArray()) 
            s.push(ch);
            
        while(!s.isEmpty()) 
            sb.append(s.pop());
        
        return sb.toString();
        
    }

}