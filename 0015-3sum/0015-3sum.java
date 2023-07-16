class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

		//without sorting we cannot perform 2sum, 3sum & 4sum
        Arrays.sort(nums);

		int j = 0;
		while(j < n) {
			//a+b+c = 0
			int l = j+1;
			int r = n-1;
		
			//2sum
			while(l < r) {
				int sum = nums[j] + nums[l] + nums[r];
				if(sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[j]);
					list.add(nums[l]);
					list.add(nums[r]);
					
					res.add(list);
					l++;
					r--;
					//to skip duplicates
					while(l < r && nums[l] == nums[l-1])  l++;
					while(l < r && nums[r] == nums[r+1])  r--;
				}
				else if(sum < 0)
					//no need to skip duplicates necessarily, because if sum not                            //equal to target, it will do l++ for all its duplicates
					l++;
				else
					r--;
			}
			j++;
			//to skip duplicates
			while(j < n && nums[j] == nums[j-1])  j++;
		}
		return res;
    }
}