//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long subarrayRanges(int n, int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        long ans = 0;
        
        //sum of subarray smaller elements
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                
                if(!s.isEmpty())  lb = s.peek();
                
                long noOfSubarr = (idx - lb) * (rb - idx);
                long sum = noOfSubarr * arr[idx];
                ans -= sum;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            long noOfSubarr = (idx - lb) * (rb - idx);
            long sum = noOfSubarr * arr[idx];
            ans -= sum;
        }
        
        //sum of subarray larger elements
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]){
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                
                if(!s.isEmpty())  lb = s.peek();
                
                long noOfSubarr = (idx - lb) * (rb - idx);
                long sum = noOfSubarr * arr[idx];
                ans += sum;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            long noOfSubarr = (idx - lb) * (rb - idx);
            long sum = noOfSubarr * arr[idx];
            ans += sum;
        }
       
        return ans;
    }
}
