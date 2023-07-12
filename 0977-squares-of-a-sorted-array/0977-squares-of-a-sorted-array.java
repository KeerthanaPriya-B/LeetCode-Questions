class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        int[] res = new int[n];

        //for(int i=n-1; i>=0; i--) {
        int i = n-1;
        while(i >= 0) {
            int x = Math.abs(nums[low]) * Math.abs(nums[low]);
            int y = Math.abs(nums[high]) * Math.abs(nums[high]);
            
            if(x > y) {
                res[i] = x;
                low++;
                i--;
            }
            else {
                res[i] = y;
                high--;
                i--;
            }
        }
        return res;
    }
}