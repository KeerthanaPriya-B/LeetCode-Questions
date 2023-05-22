class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, res, new ArrayList<>());
        return res;
    }

    static void subset(int[] nums, int i, List<List<Integer>> res, List<Integer> ans){

        if(i == nums.length){
            res.add(new ArrayList(ans));
            return;
        }

        //ans.add(nums[i]);
        subset(nums, i+1, res, ans);
        ans.add(nums[i]);

        
        subset(nums, i+1, res, ans);
        ans.remove(ans.size()-1);
    }
}