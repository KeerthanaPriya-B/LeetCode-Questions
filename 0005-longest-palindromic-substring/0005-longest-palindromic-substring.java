class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        String LPS = String.valueOf(s.charAt(0));
        
        for(int i=1; i<n; i++) {
            //odd length
            int low = i;
            int high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low == -1 || high == n)  break;
            }
            
            String palin = s.substring(low+1, high);
            LPS = (palin.length() > LPS.length()) ? palin : LPS;
            
            
            //even length
            low = i-1;
            high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low == -1 || high == n)  break;
            }
            
            palin = s.substring(low+1, high);
            LPS = (palin.length() > LPS.length()) ? palin : LPS;
        }
        return LPS;
    }
}