class Solution {
    public int maxSubArray(int[] nums) {
        
        int train = 0, max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            int newTrain = nums[i];
            int prevTrain = nums[i] + train;
            
            train = Math.max(newTrain, prevTrain);
            max = Math.max(max, train);
        }
        return max;
    }
}