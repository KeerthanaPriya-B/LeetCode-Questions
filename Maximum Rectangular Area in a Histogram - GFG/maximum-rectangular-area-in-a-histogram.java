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
        //solved using approach Montonic stack
		//for doubts- 12th june Stack 2 watch lecture(time 2:15:00)
		
		Stack<Integer> s = new Stack<>();
		long maxarea = 0;
		  
		for(int i=(int)n-1; i>=0; i--)
		{
		  while(!s.isEmpty() && hist[i] < hist[s.peek()]){
			  int lb = i;
			  int rb = (int)n;
			  int idx = s.pop();
			  if(!s.isEmpty())  rb = s.peek();
		
			  long width = rb - lb - 1;
			  long area = width * hist[idx];
			  maxarea = Math.max(maxarea, area);				  
		  }
		  s.push(i);
		}
		  
		while(!s.isEmpty()){
			int lb = -1;
			int rb = (int)n;
			int idx = s.pop();
			if(!s.isEmpty())  rb = s.peek(); 
			
			long width = rb - lb - 1;
			long area = width * hist[idx];
			maxarea = Math.max(maxarea, area);	
		}
		return maxarea;
    }
        
}



