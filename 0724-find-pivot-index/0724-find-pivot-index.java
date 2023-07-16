class Solution {
    public int pivotIndex(int[] arr) {
        
        
        //watched video from Techdose Utube Channel
        
        //SC: O(1)
        int n = arr.length;
        int tot = 0;
        for(int ele: arr)  tot += ele;
        
        int left = 0;
        for(int i=0; i<n; i++) 
        {
            tot -=arr[i];
            if(tot == left) return i;
            left += arr[i];
        }
        
        return -1;
        
        //SC: O(N)
//         int n = nums.length;
//         if(n == 1)  return 0;
        
//         int sum[] = new int[n];
//         int tot = 0;
        
//         for(int i=0; i<n; i++) {
//             tot += nums[i];
//             sum[i] = tot;
//         }
        
//         for(int i=0; i<n; i++) {
//             int Lsum = sum[i] - nums[i];
//             int Rsum = tot - sum[i];
            
//             if(Lsum == Rsum)  return i;
//         }
//         return -1;   
    }
}