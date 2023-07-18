class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> list = new ArrayList<>();
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