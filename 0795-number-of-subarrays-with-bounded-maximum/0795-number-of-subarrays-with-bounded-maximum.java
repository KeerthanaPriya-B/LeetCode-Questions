class Solution {
    public int numSubarrayBoundedMax(int[] a, int L, int R) {
        int si = -1;
        int ei = -1;
        int noOfarr = 0;
        int n = a.length;
        
        for(int i=0; i<n; i++) {
            if(a[i] > R) {
                si = i;
                ei = i;
                continue;
            }
            if(a[i] >= L) {
                ei = i;
            }
            
            noOfarr += ei - si ;
        }
        return noOfarr;
    }
}