class Solution {
    public void setZeroes(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean rowcheck = false;
        boolean colcheck = false;
        
        //Checking row for 0's
        for(int j=0; j<m; j++) {
            if(mat[0][j] == 0) {
                rowcheck = true;
                break;
            }
        }
        //Checking col for 0's
        for(int i=0; i<n; i++) {
            if(mat[i][0] == 0) {
                colcheck = true;
                break;
            }
        }
        
        //marking 0th row & col as 0 where zero is present in matrix
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
        
        //traversing through 0th row & marking corresponding col zero
        for(int j=1; j<m; j++) {
            if(mat[0][j] == 0) {
                for(int i=1; i<n; i++) 
                    mat[i][j] = 0;
            }
        }
        //traversing through 0th col & marking corresponding row zero
        for(int i=1; i<n; i++) {
            if(mat[i][0] == 0) {
                for(int j=1; j<m; j++) 
                    mat[i][j] = 0;
            }
        }
        
        //now cheecking whether 0th cor & col itself has any zero
        if(rowcheck) {
          for(int j=0; j<m; j++) 
              mat[0][j] = 0;
        }
        if(colcheck) {
            for(int i=0; i<n; i++)
              mat[i][0] = 0;
        }
        
        
        
        
        
    }
}