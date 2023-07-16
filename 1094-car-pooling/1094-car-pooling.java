class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        //13th july recording time(1:2:00)

		//prefStep - prefix steps
		int[] prefStep = new int[1001];

		for(int[] trip: trips) {
			int NoOfPeople = trip[0];
			int from = trip[1];
			int To = trip[2];
			prefStep[from] += NoOfPeople;
			prefStep[To] -= NoOfPeople;
		}

		//calculating prefix sum
		for(int i=1; i<1001; i++) 
			prefStep[i] += prefStep[i-1];

		for(int passengers: prefStep) {
			if(passengers > capacity)
				return false;
		}
		return true;
    }
}