class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        
        
        // for(int i=n-1; i>=0; i--) 
        //     stack.push(nums[i]);
        
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