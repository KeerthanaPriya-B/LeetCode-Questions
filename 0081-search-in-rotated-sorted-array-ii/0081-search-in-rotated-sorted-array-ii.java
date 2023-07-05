class Solution {
    public boolean search(int[] nums, int target) {
        
        int l=0, h=nums.length-1;
        
        while(l <= h) {
            int mid = (l+h)/2;
            
            //if target val is found
            if(nums[mid] == target)
                return true;
            
            //if all points to the duplicates
            if(nums[l] == nums[mid] && nums[h] == nums[mid]) {
                l++;
                h--;
            }
            //checking whether it lies in the sorted region
            // '=' in the condition for cases like [3, 1] target = 1
            else if(nums[l] <= nums[mid]) {
                if(target >= nums[l] && target < nums[mid])
                    h = mid -1;
                else
                    l = mid + 1;
            }
            else{
                if(target > nums[mid] && target <= nums[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
                
        }
        return false;
    }
}