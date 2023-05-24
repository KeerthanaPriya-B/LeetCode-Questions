class Solution {
    public int search(int[] nums, int target) {
        
        return helper(nums, target, 0, nums.length-1);
    }
    
    static int helper(int[] nums, int target, int start, int end){
        
        if(start > end)  return -1;
        
        int mid = start + (end-start)/2;
        
        if(target == nums[mid]) return mid;
        
        if(target < nums[mid])  
            return helper(nums, target, start, mid-1);
        
        return helper(nums, target, mid+1, end);
    }
}


// if(st>end)return -1;
    
//     int mid = st+(end-st)/2;
    
//     if(nums[mid] == target) return mid;
    
//     if(nums[mid] < target) return sum(nums,mid+1,end, target);
    
//     else return sum(nums,st,mid-1, target); 