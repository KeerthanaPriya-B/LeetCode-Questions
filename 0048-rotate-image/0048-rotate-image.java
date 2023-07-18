class Solution {
    public void rotate(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        //transpose
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i < j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        
        //reversing rows
        for(int i=0; i<n; i++) {
            int[] arr = mat[i];
            
            int j=0;
            int k=m-1;
            while(j < k) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                j++;
                k--;
            }
        }
    }
}