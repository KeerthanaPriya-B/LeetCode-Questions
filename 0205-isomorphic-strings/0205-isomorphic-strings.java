class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char original = s.charAt(i);
            char main = t.charAt(i);
            
            if(!map.containsKey(original)) {
                if(!map.containsValue(main)) {
                    map.put(original, main);
                }
                else  return false;
            }
            else {
                char mappedChar = map.get(original);
                if(mappedChar != main)  return false;
            }
        }
        return true;
        
    }
}