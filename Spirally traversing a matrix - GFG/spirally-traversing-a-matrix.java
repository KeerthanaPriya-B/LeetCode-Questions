//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int mat[][], int r, int c)
    {
        // code here 
        
        ArrayList<Integer> list = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;
        
        while(top <= bottom && left <= right) {
            boolean firstloop = false;
            boolean secondloop = false;
            boolean thirdloop = false;
            
            for(int i=left; i<=right; i++) {
                list.add(mat[top][i]);
                firstloop = true;
            }
            
            if(firstloop) {
                for(int i=top+1; i<=bottom; i++) {
                    list.add(mat[i][right]);
                    secondloop = true;
                }
            }
            
            if(secondloop) {
                for(int i=right-1; i>=left; i--) {
                    list.add(mat[bottom][i]);
                    thirdloop = true;
                }
            }
            
            if(thirdloop) {
                for(int i=bottom-1; i>top; i--) {
                    list.add(mat[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}
