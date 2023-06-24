class Solution {
    public int searchInsert(int[] arr, int k) {
        
        int N = arr.length;
        int low = 0, high = N-1, ans = -1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        if(ans == -1) return N;
        return ans;
    }
}