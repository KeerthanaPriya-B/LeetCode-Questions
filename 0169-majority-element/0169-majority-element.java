class Solution {
    public int majorityElement(int[] nums) {
        
        
        //Moore's Voting Algorithm
        //striver's code
        
        
        int times = nums.length/2;
        int val = 0, cnt = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(cnt == 0) {
                val = nums[i];
                cnt = 1;
            }
            else if(nums[i] == val) cnt++;
            else cnt--;
        }
        
        // cnt = 0;
        // for(int i=0; i<nums.length; i++) {
        //     if(val == nums[i])  cnt++;
        // }
        
        //if(cnt > times) 
        return val;
        //return -1;
        
        
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int ele: nums)
//             map.put(ele, map.getOrDefault(ele, 0) + 1);
        
//        for(int key: map.keySet()) { 
//            if(map.get(key) > times)
//                return key;
//        }
//         return 0;
    }
}