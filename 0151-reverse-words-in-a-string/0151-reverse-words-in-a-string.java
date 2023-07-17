class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i=0, n=s.length();
        
        while(i < n) {
            if(s.charAt(i) != ' ') {
                int j = i+1;
                
                while(j < n && s.charAt(j) != ' ')
                    j++;
                
                String str = s.substring(i, j);
                sb.insert(0, str + " ");
                i = j-1;
            }
            i++;
        }
        return sb.toString().trim();
    }
}