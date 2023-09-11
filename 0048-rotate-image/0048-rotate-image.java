class Solution {
    public void rotate(int[][] mat) {
        
        int n = mat.length;
        
        //transpose
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        //reversing rows
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
//             int[] arr = mat[i];
            
//             int j=0;
//             int k=m-1;
//             while(j < k) {
//                 int temp = arr[j];
//                 arr[j] = arr[k];
//                 arr[k] = temp;
//                 j++;
//                 k--;
//             }
        }
    }
}