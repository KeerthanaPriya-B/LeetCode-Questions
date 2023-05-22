class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        combination(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    static void combination(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res){

        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == candidates.length){
            if(target == 0){
               res.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(candidates[i] <= target)
        {
            list.add(candidates[i]);
            combination(candidates, target-candidates[i], i, list, res);
            list.remove(list.size()-1);
        }
        combination(candidates, target, i+1, list, res);
    }
}