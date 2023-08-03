class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return cntsubarr(nums, k) - cntsubarr(nums, k-1);
    }
    public int cntsubarr(int[]nums, int k) {
        int n = nums.length;
        int si = 0;
        int ei = 0;
        int dk = 0;
        int cnt = 0;
        
        while(ei < n) {
            if(nums[ei]%2 != 0) dk++;
            
            while(dk > k) {
                if(nums[si]%2 != 0) dk--;
                si++;
            }
            
            cnt += ei-si+1;
            ei++;
        }
        return cnt;
    }
}