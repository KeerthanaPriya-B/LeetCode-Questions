class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        int ans = 0;
        
        //inputing all the array elemnts
        for(int i: nums)
            set.add(i);
        
        //traversing through the array
        for(int i=0; i<nums.length; i++) {
            //checking whether it can be a starting element
            if(set.contains(nums[i] - 1)) {
                continue;
            }
            
            int val = nums[i];
            //finding its next consecutive ele
            while(set.contains(val)) {
            //set.remove(val);
                val++;
            }
            
            //updating the ans
            if(val - nums[i] > ans)
                ans = val - nums[i];
        }
        return ans;
    }
}