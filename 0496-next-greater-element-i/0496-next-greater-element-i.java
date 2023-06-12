class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        
        //traversing from front to end approach 
        for(int n: nums2){
             while(!s.isEmpty() && s.peek() < n)
                 map.put(s.pop(), n); 
            s.push(n);
        }
        for(int i=0; i<nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        
        return nums1;
        
        
         //traversing from end to front approach 
//         for(int i=nums2.length-1; i>=0; i--)
//         {
//             while(!s.isEmpty() && s.peek() < nums2[i])
//                 s.pop();
            
//             if(s.isEmpty())
//                 map.put(nums2[i], -1);
//             else
//                 map.put(nums2[i], s.peek());
            
//             s.push(nums2[i]);
//         }
        
//         for(int i=0; i<nums1.length; i++)
//             nums1[i] = map.get(nums1[i]);
         
//         return nums1;
    }
}