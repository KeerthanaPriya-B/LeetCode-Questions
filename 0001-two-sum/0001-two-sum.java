class Solution {
    public int[] twoSum(int[] A, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<A.length; i++) {
			int x = target - A[i];

			if(map.containsKey(x)) {
				int[] arr = new int[2];
				return new int[]{map.get(x), i};
			}
			map.put(A[i], i);
		}
		return new int[0];
    }
}