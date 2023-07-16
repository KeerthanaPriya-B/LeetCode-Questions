class Solution {
    public int longestOnes(int[] arr, int k) {
        
        //***************** sliding window **********************
		
		//this is a common template for all sliding window concept
		//1. Introduce new ele
		//2. shrink if invalid
		//3. update
		//4. expand

		//15th july recording time(02:05:00)

		int n = arr.length;
		int start = 0;
		int end = 0;
		
		//based on this cnt, we shrink the window
		int noOfZeros = 0;
		int maxOnes = 0;

		while(end < n) {
			//introduce new ele in window
			if(arr[end] == 0)  noOfZeros++;

			//shrink if the window has zeros greater than k
			while(noOfZeros > k) {
				if(arr[start] == 0)  noOfZeros--;
				start++;
			}

			//update One's cnt
			maxOnes = Math.max(maxOnes, end-start+1);

			//expand window
			end++;
			
		}
		return maxOnes;
    }
}