class Solution {
    public int search(int[] arr, int k) {
        
        int n = arr.length;
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}