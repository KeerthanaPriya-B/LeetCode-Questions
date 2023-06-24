class Solution {
    public int[] searchRange(int[] arr, int x) {
        
        int[] res = new int[2];
        int n = arr.length;
        res[0] = FirstOccur(arr, n, x);
        res[1] = LastOccur(arr, n, x);
        return res;
    }
    
    int FirstOccur(int arr[], int n, int x) {
        int low = 0, high = n-1, ans = -1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == x) {
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid] > x)
               high = mid-1;
            else
                low = mid+1;
        }
        return ans;
    }
    
    int LastOccur(int arr[], int n, int x) {
        int low = 0, high = n-1, ans = -1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == x) {
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid] < x) 
                low = mid+1;
            else
                 high = mid-1;
        }
        return ans;
    }
}