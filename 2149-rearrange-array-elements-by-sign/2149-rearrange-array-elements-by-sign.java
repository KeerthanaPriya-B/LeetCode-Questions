class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        //Striver's code
        //if +ve and -ve elements are not equal in length
        //TC: O(N+N)  SC: O(N)
        
        int n = nums.length;
        
        int[] res = new int[n];
        ArrayList<Integer> posi = new ArrayList<>();
        ArrayList<Integer> nega = new ArrayList<>();
        
        
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) posi.add(nums[i]);
            if(nums[i] < 0) nega.add(nums[i]);
        }
        
        if(posi.size() > nega.size()) {
            for(int i=0; i<nega.size(); i++) {
                res[2*i] = posi.get(i);
                res[2*i+1] = nega.get(i);
            }
            int idx = nega.size()*2;
            for(int j=nega.size(); j<posi.size(); j++)
                res[idx++] = posi.get(j);
        } 
        else {
            for(int i=0; i<posi.size(); i++) {
                res[2*i] = posi.get(i);
                res[2*i+1] = nega.get(i);
            }
            int idx = posi.size()*2;
            for(int j=posi.size(); j<nega.size(); j++)
                res[idx++] = nega.get(j);
        }
        return res;
        

        //if +ve and -ve elements are equal in length
        //TC: O(N)  SC: O(N)
        
//         int[] res = new int[nums.length];
//         int positive = 0, negative = 1;
        
//         for(int i=0; i<nums.length; i++) {
//             if(nums[i] > 0) {
//                 res[positive] = nums[i];
//                 positive += 2;
//             } else {
//                 res[negative] = nums[i];
//                 negative += 2;
//             }
//         }
//         return res;
    }
}