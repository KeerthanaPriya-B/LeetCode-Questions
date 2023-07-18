class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            char main = t.charAt(i);
            
            if(map.containsKey(ch)) {
                if(map.get(ch) != main)  return false;
            }
            else {
                map.put(ch, main);
            }
        }
        
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = t.charAt(i);
            char main = s.charAt(i);
            
            if(map2.containsKey(ch)) {
                if(map2.get(ch) != main)  return false;
            }
            else {
                map2.put(ch, main);
            }
        }
         return true;
    }
}