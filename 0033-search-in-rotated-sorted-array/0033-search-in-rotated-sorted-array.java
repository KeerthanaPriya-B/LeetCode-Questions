class Solution {
    public int search(int[] A, int key) {
        
        int n = A.length;
        int l = 0, h = n-1;
        
        while(l <= h) {
            int mid = (l+h)/2;
            
            if(A[mid] == key)
                return mid;
                
            else if(A[l] <= A[mid]) {
                if(key >= A[l] && key < A[mid])
                    h = mid-1;
                else
                    l = mid+1;
            }
            else {
                if(key > A[mid] && key <= A[h])
                    l = mid+1;
                else
                    h = mid-1;
            }
        }
        return -1;
    }
}