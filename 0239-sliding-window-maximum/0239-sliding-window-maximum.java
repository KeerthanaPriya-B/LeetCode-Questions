class Solution {
    public int[] maxSlidingWindow(int[] arr, int K) {
        
        //brute force approach - TC: O(N^2) SC: O(k->no.of windows)
		//refer Striver's DSA sheet written code & explanation for brute force 
		
		//refer - 15th june Queue 2 (time 3:00:00)

		//TC: O(N)  SC: O(K)
		Deque<Integer> dq = new ArrayDeque<>();
        int N = arr.length;
		int[] res = new int[N-K+1];
		int idx = 0;

		for(int i=0; i<N; i++){
			// remove numbers out of range k
			if(!dq.isEmpty() && dq.getFirst() <= i-K)
				dq.removeFirst();

			// remove smaller numbers in k range
			while(!dq.isEmpty() && arr[dq.getLast()] < arr[i])
				dq.removeLast();

			dq.addLast(i);
			if(i >= K-1) 
				res[idx++] = arr[dq.getFirst()];
			
		}
		return res;
    }
}