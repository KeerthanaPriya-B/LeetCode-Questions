//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        // code here
        
        int low = 1, high = 0, k=-1;
        for(int i: piles)
            high = Math.max(high, i);
            
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(ispossible(mid, piles, H)) {
                k = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return k;
    }
    public static boolean ispossible(int limit, int[] piles, int H) {
        
        int hours=0;
        for(int i: piles) {
            // hours += i/limit;
            // if(i/limit != 0)  hours++;
            hours += (i+limit-1)/limit;
        }
        return hours <= H;
    }
}
        
