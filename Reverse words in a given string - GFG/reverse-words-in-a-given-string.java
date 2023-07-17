//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        StringBuilder sb = new StringBuilder();
        int i=0, n=s.length();
        
        while(i < n) {
            int j = i+1;
            
            while(j < n && s.charAt(j) != '.')
                j++;
            
            String str = s.substring(i, j);
            sb.insert(0, "."+str);
            i = j+1;
            
            //i++;
        }
        return sb.deleteCharAt(0).toString();
        //return s;//s.replace(s.charAt(n-1), '\0');
    }
}