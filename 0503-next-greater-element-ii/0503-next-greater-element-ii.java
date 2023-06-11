class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        
        
        for(int i=n-1; i>=0; i--) stack.push(nums[i]);
        
        for(int i=n-1; i>=0; i--){
            //if(nums[i] < stack.peek())
            while(!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            
            if(!stack.isEmpty()) {
                ans[i] = stack.peek();
            }else{
                ans[i] = -1;
            }
            
            stack.push(nums[i]);
        }
        return ans;
    }
}