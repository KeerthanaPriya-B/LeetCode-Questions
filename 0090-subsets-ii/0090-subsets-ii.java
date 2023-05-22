class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, res, new ArrayList<>());
        return res;

    }

    static void subset(int[] nums, int ind, List<List<Integer>> res, List<Integer> ans){

        res.add(new ArrayList(ans));

        for(int i=ind; i<nums.length; i++)
        {
            if(i != ind && nums[i] == nums[i-1])
                continue;

            ans.add(nums[i]);
            subset(nums, i+1, res, ans);
            ans.remove(ans.size()-1);
        }
    }
}