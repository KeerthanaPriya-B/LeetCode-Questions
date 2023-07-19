class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;
        int ones = 0;
        int i = 0;
        int ans = 0;
        
        while(i < n) {
            if(nums[i] == 1) ones++;
            else  ones = 0;

            ans = Math.max(ans, ones);
            i++;
        }
        return ans;
    }
}