class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        PaliPart(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    static void PaliPart(String s, int ind, List<String> ans, List<List<String>> res){
        
        if(ind == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=ind; i<s.length(); i++)
        {
            if(palindrome(s, ind, i)){
                ans.add(s.substring(ind, i+1));
                PaliPart(s, i+1, ans, res);
                ans.remove(ans.size()-1);
            }
        }
    }
    
    static boolean palindrome(String s, int start, int end){
        
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;
        
        return palindrome(s, start+1, end-1);
    }
}