class Solution {
    public int maxDistance(int[] position, int m) {
        
        
		//recording 20th june binary search 3(time- 2:00:00)
		//TC: O(N* logN)  SC: O(1)

		
		Arrays.sort(position);
		int n = position.length, large = 0;

		//setting limits;
		int high = position[n-1] - position[0];
		int low = Integer.MAX_VALUE;

		//min distance b/w two consecutive stall
		for(int i=1; i<n; i++) {
			int dis = position[i] - position[i-1];
			low = Math.min(low, dis);
		}
		
		while(low <= high) {
			int mid = (low+high)/2;

			if(Ispossible(position, mid, m)) {
				large = mid;
				low = mid+1;
			} else
				high = mid-1;	
		}
		return large;
    }
	
	public static boolean Ispossible(int position[], int dis, int m){

		int ballCnt = 1, prevposition = position[0];

		for(int i=1; i<position.length; i++) {
			if(position[i]-prevposition >= dis) {
				ballCnt++;
				prevposition = position[i];
			}
		}
		return ballCnt >= m;
	}
}