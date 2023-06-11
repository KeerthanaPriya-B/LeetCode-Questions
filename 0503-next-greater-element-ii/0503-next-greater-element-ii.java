class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>(); //O(N)
        int n = nums.length;
        int[] ans = new int[n]; //O(N)
        
        //this way of doing includes, for(i=n-1 -> 0) and remove %n
        // for(int i=n-1; i>=0; i--) 
        //     stack.push(nums[i]);
        
        
        
        //TC: O(2N + 2N) approx O(N)  SC: we usually won't consider space used to stote result, so the SC: O(N)
        for(int i=2*n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]) 
                stack.pop();
            
            if(!stack.isEmpty()) 
                ans[i%n] = stack.peek();
            else
                ans[i%n] = -1;
              
            stack.push(nums[i%n]);
        }
        
        return ans;
    }
}