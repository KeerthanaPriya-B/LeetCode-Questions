class Solution {
    public int majorityElement(int[] nums) {
        
        int times = nums.length/2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele: nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
       for(int key: map.keySet()) {
           //if(map.containsKey(key)) 
               if(map.get(key) > times)
                   return key;
           //}
       }
        return 0;
    }
}