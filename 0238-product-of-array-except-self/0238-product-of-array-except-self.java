class Solution {
    public int[] productExceptSelf(int[] a) {
        
        int n = a.length;
        int[] res = new int[n];
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];
        
		prefixProd[0] = 1;
        for(int i=1; i<n; i++) {
            prefixProd[i] = a[i-1] * prefixProd[i-1];
        }
        
        suffixProd[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            suffixProd[i] = a[i+1] * suffixProd[i+1];
        }
        
		for(int i=0; i<n; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
		return res;
    }
}