class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int cnt = 0, y = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            //x + y = k --> x = y - k
            y += nums[i];
            int x = y - k;
            if(map.containsKey(x)) {
                cnt += map.get(x);
            }
            
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        return cnt;
    }
}