//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        
        Stack<Integer> s = new Stack<>();
        
        for(int ele: asteroids){
            if(ele>0)
                s.push(ele);
            else{
                //stack.peek()-positive case
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(ele))
                    s.pop();
                
                //stack.peek()-empty & negative case
                if(s.isEmpty() || s.peek()<0)
                    s.push(ele);
                
                //stack.peek()-equal case
                else if(!s.isEmpty() && s.peek()==Math.abs(ele))
                    s.pop();
            }
        }
        
        int[] res = new int[s.size()];
        
        for(int i=s.size()-1; i>=0; i--)
            res[i] = s.pop();
        
        return res;
    }
}
