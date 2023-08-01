class Solution {
    public int countAtMostK(int[] nums, int k) {
        
        int count = 0;
        int left = 0;
        int oddCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            // Count the subarrays with at most k odd numbers
            count += right - left + 1;
        }

        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        
        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }
}