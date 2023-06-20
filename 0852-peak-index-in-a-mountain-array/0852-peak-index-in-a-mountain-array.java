class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        int start = 0, end = A.length;

        //recording: 19th june Binary search 2 time(2:30:00)
		//TC: O(log n)  SC: O(1)
        
        
		while(start <= end) {
			int mid = (start+end)/2;

			if(mid == 0) {  //cases like 1 2 3 4 5
				if(A[mid] > A[mid+1])
					return mid;
				else
					//move right
					start = mid+1;
			}
			else if(mid == A.length-1) {  // cases like 5 4 3 2 1 
				if(A[mid] > A[mid-1])
					return mid;
				else
					//move left
					end = mid-1;
			}
			else {
				if(A[mid-1] < A[mid] && A[mid] > A[mid+1])
					return mid;
				else if(A[mid-1] < A[mid])
					//increasing side
					//move towards right
					start = mid+1;
				else
					//decreasing side
					//move towards left
					end = mid-1;
			}
			
		}
		return -1;
        
    }
}