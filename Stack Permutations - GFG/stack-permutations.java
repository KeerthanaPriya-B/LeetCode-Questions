//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.isStackPermutation(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        // code here
        
        Stack<Integer> s = new Stack<>();
        
        // for(int i=0; i<n; i++) {
            
        // }
        int i=0, j=0, ans=0;
        while(true) {
            s.push(ip[i]);
            
            while(!s.isEmpty() && s.peek()==op[j]) {
                s.pop();
                j++;
            }
            i++;
            
            if(j==n && s.isEmpty()) {ans=1; break;}
            if(i==n && !s.isEmpty()) {break;}
        }
        return ans;
        
    }
}
            
