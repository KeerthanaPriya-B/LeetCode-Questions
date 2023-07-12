class Solution {
    public long countVowels(String word) {
        
        long total = 0;
        long n = word.length();
        
        for(int idx = 0; idx < n; idx ++) 
        {
            char ch = word.charAt(idx);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                long subtrings_From_currInd = n - idx;
                
                long substrings_From_prevInds = (idx * subtrings_From_currInd);
                
                total += subtrings_From_currInd + substrings_From_prevInds;
            }
        }
        
        return total;
    }
}