class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;
        int ones = 0;
        int end = 0;
        int ans = 0;
        
        while(end < n) {
            if(nums[end] == 1) ones++;
            else {
                
                ones = 0;
            }
            ans = Math.max(ans, ones);
            end++;
        }
        return ans;
    }
}