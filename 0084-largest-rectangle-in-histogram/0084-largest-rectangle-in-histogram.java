class Solution {
    public int largestRectangleArea(int[] heights) {
        
        
        //solved using approach Montonic stack
		//for doubts- 12th june Stack 2 watch lecture(time 2:15:00)
        
        int n = heights.length;
        
        Stack<Integer> s = new Stack<>();
        int maxarea = 0;
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                
                if(!s.isEmpty())  lb = s.peek();
                
                int width = rb - lb - 1;
                int area = width * heights[idx];
                maxarea = Math.max(maxarea, area);
            }
            s.push(i);
        }
       while(!s.isEmpty()) {
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            int width = rb - lb - 1;
            int area = width * heights[idx];
            maxarea = Math.max(maxarea, area);
        }  
        
      return maxarea;
     
    }
}