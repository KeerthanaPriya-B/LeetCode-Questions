class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        //exactly k odd = atmost k odds - atmost k-1 odds
        return cntSubArr(nums, k) - cntSubArr(nums, k-1);
    }
    
    public int cntSubArr(int[] nums, int k) {
        int n = nums.length;
        int si = 0;
        int ei = 0;
        int cnt = 0;
        
        //depending on this we shrink the window
        int odds = 0;
        
        while(ei < n) {
            if(nums[ei]%2 != 0) odds++;
            
            //if odd cnt exceeding k, shrink
            while(odds > k) {
                //if start index is odd decrement odd cnt
                if(nums[si]%2 != 0) odds--;
                si++;
            }
            //update cnt of subarrays
            cnt += ei-si+1;
            
            //expand the window
            ei++;
        }
        return cnt;
    }
}