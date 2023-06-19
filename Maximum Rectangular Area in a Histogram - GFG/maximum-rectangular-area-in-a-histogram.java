//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long maxArea = 0;
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<(int)n; i++) {
            while(!s.isEmpty() &&  hist[s.peek()] > hist[i]) {
                int idx = s.pop();
                int rb = i;
                int lb = -1;
                if(!s.isEmpty())  lb = s.peek();
                
                long width = rb - lb - 1;
                long area = hist[idx] * width;
                maxArea = Math.max(maxArea, area);
            }
            s.push(i);
        }
        while(!s.isEmpty()) {
            int idx = s.pop();
            int rb = (int)n;
            int lb = -1;
            if(!s.isEmpty())  lb = s.peek();
            
            long width = rb - lb - 1;
            long area = hist[idx] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
        
    }
        
}



