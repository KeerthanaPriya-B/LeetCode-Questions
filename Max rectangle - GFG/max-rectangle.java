//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.

        int[][] matrix = new int[n][m];
        int area = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = M[i][j];
                
                if(M[i][j] != 0 && i != 0)
                    matrix[i][j] += matrix[i-1][j];
            } }
            
        for(int[] arr: matrix)
            area = Math.max(area, largeArea(arr, m));
            
        return area;
    }
    
    public int largeArea(int arr[], int N){
        
        Stack<Integer> s = new Stack<>();
        int MAX_AREA = 0;
        
        for(int i=0; i<N; i++){
            while(!s.isEmpty() && arr[i] < arr[s.peek()]){
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                if(!s.isEmpty())  lb = s.peek();
                
                int width = rb - lb - 1;
                int area = width * arr[idx];
                MAX_AREA = Math.max(MAX_AREA, area);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = N;
            int lb = -1;
            int idx = s.pop();
            if(!s.isEmpty())  lb = s.peek();
            
            int width = rb - lb - 1;
            int area = width * arr[idx];
            MAX_AREA = Math.max(MAX_AREA, area); 
        }
        return MAX_AREA;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}