class Solution {
    public boolean rotateString(String A, String B) {
        
        if(A.length() != B.length()) {
            return false;
        }
        
        int n = A.length();
        
        for(int i = 0; i < n; i++) {
            if(rotateString(A, B, i)) {
                return true;
            }
        }
        return false;          
    }
    
    public boolean rotateString(String A, String B, int rotation) {
        int n = A.length();
        
        for(int i = 0; i < n; i++) {
            if(A.charAt(i) != B.charAt((i + rotation) % n)) {
                return false;
            }
        }
        return true;
    }
}