class NumMatrix {

    int[][] prefix;
    public NumMatrix(int[][] mat) {
        
        int n = mat.length;
		int m = mat[0].length;

		prefix = new int[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int A = mat[i][j];
				int B = (i-1 < 0) ? 0 : prefix[i-1][j];
				int C = (j-1 < 0) ? 0 : prefix[i][j-1];
				int D = (i-1 < 0 || j-1 < 0) ? 0 : prefix[i-1][j-1];
				
				prefix[i][j] = A + B + C - D;
			}
		}
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        
        int A = prefix[r2][c2];
        int B = (r1-1 < 0) ? 0 : prefix[r1-1][c2];
        int C = (c1-1 < 0) ? 0 : prefix[r2][c1-1];
        int D = (r1-1 < 0 || c1-1 < 0) ? 0 : prefix[r1-1][c1-1];

        //adding D because, we are subtracting it two times
        int ans = A - B - C + D;
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */