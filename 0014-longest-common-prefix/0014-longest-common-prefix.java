class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        
        for(int i=1; i<strs.length; i++) {
            String wrd = strs[i];
            
            int j = 0, k = 0;
            
            while(j < wrd.length() && k < prefix.length()) {
                if(wrd.charAt(j) != prefix.charAt(k))
                    break;
                j++;
                k++;
            }
            
            prefix = prefix.substring(0, j);
        }
        
        return prefix;
    }
}