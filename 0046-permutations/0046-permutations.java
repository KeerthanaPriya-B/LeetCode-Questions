class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, 0, res);
        return res;
    }

    static void permutation(int[] nums, int ind,  List<List<Integer>> res){

        if(ind == nums.length)
        {
            List<Integer> ans = new ArrayList<>();
            for(int i: nums)
                ans.add(i);
            
            res.add(ans);
            return;
        }

        for(int i=ind; i<nums.length; i++)
        {
            swap(nums, i, ind);
            permutation(nums, ind+1, res);
            swap(nums, i, ind);
        }
    }
    
    static void swap(int[] nums, int i, int ind){
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
}