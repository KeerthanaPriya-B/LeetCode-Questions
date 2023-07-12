class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        int[] res = new int[n];

        int i = n-1;
        while(i >= 0) {
            int x = nums[low] * nums[low];
            int y = nums[high] * nums[high];
            
            if(x > y) {
                res[i] = x;
                low++;
            } else {
                res[i] = y;
                high--;
            }
            i--;
        }
        
        return res;
    }
}