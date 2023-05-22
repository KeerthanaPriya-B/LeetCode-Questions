class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    static void combination(int ind, int[] candidates, int target, List<Integer> ans, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList(ans));
            return;
        }

        for(int i=ind; i<candidates.length; i++)
        {
            if(i != ind && candidates[i] == candidates[i-1]) 
                continue;

            if(candidates[i] > target) 
                break;
                
            ans.add(candidates[i]);
            combination(i+1, candidates, target-candidates[i], ans, res);
            ans.remove(ans.size()-1);
        }
    }
}