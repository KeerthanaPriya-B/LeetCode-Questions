class Solution {
    public int missingNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        int n = nums.length;
        
        for(int ele: nums)  set.add(ele);
        
        for(int i=0; i<=n; i++) {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }
}