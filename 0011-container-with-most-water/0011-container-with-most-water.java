class Solution {
    public int maxArea(int[] height) {
        
        int area=0, maxArea=0, i=0, j=height.length-1;

        while(i < j)
        {
            area = Math.min(height[i], height[j]) * (j-i);
            maxArea = Math.max(maxArea, area);

            if(height[i] < height[j]) i++;
            else  j--;
        }

        return maxArea;
    }
}