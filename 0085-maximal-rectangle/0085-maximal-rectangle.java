class Solution {
    public int maximalRectangle(char[][] M) {
        
        int n = M.length;
        int m = M[0].length;
        int area = 0;
        int[][] matrix = new int[n][m];
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = M[i][j]-'0';
                
                if(M[i][j] != '0' && i > 0)
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