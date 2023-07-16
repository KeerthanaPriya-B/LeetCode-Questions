class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
         
        int i=0;
        //4sum
        while(i < n) {
            int j = i+1;
            //3sum
            while(j < n) {
                //a+b+c+d = target -> c+d = target - (a+b)
                long newTarget = (long)target - ((long)nums[i] + (long)nums[j]);
                
                int l = j+1;
                int r = n-1;
                //2sum
                while(l < r) {
                    long sum = (long)nums[l] + (long)nums[r];
                    
                    if(sum == newTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        
                        res.add(list);
                        l++;
                        r--;
                        //to skip duplicates
                        while(l < r && nums[l] == nums[l-1])  l++;
                        while(l < r && nums[r] == nums[r+1])  r--;
                    }
                    else if(sum < newTarget)
                        //no need to skip duplicates necessarily, because if sum not                            //equal to target, it will do l++ for all its duplicates
                        l++;
                    else
                        r--;
                }
                j++;
                //to skip duplicates
                while(j < n && nums[j] == nums[j-1])  j++;
            }
            i++;
            //to skip duplicates
            while(i < n && nums[i] == nums[i-1])  i++;
        }
        return res;
    }
}