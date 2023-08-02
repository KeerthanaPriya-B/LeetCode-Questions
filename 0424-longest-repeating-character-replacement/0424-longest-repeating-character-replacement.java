class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
       
        int si = 0;
        int ei = 0;
        int maxlen = 0;
        int maxChar = 0;

        while(ei < n) {
            char ch = s.charAt(ei);
            
            freq[ch - 'A']++;
            maxChar = Math.max(maxChar, freq[ch - 'A']);
            
            if (ei-si+1 - maxChar > k) {
                freq[s.charAt(si) - 'A']--;
                si++;
            }
            maxlen = Math.max(maxlen, ei-si+1);
            ei++;
        }
        return maxlen;
    }
}