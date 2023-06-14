class Solution {
    public int trap(int[] arr) {
        
        int n = arr.length;
        int lb = arr[0], rb = arr[n-1], left = 1, right = n-2;
		 int waterAmt = 0, heightOfBlock = 0;

		while(left <= right){
			if(lb <= rb){
				heightOfBlock = lb;
				
				if(heightOfBlock > arr[left]) 
					waterAmt += heightOfBlock - arr[left];
				else
					lb = Math.max(lb, arr[left]);
				
				left++;
			} 
			else {
				heightOfBlock = rb;
				
				if(heightOfBlock > arr[right]) 
					waterAmt += heightOfBlock - arr[right];
				else
					rb = Math.max(rb, arr[right]);
				
				right--;
			}
		}
		return waterAmt;

//         int n = height.length;
//         int left = 0, right = n - 1;
//         int res = 0;
//         int maxLeft = 0, maxRight = 0;
        
//         while (left <= right) {
//             if (height[left] <= height[right]) {
//                 if (height[left] >= maxLeft) {
//                     maxLeft = height[left];
//                 } else {
//                     res += maxLeft - height[left];
//                 }
//                 left++;
//             } else {
//                 if (height[right] >= maxRight) {
//                     maxRight = height[right];
//                 } else {
//                     res += maxRight - height[right];
//                 }
//                 right--;
//             }
//         }
//         return res;
    }
}