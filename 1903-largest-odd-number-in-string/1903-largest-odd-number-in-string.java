class Solution {
    public String largestOddNumber(String num) {
        
        int ind = -1;
        for(int i=num.length()-1; i>=0; i--) {
            int n = num.charAt(i) - '0';
            if(n%2 != 0) {
                ind = i;
                break;
            }
        }
        
        if(ind == -1) return "";
        return num.substring(0, ind+1);
    }
}