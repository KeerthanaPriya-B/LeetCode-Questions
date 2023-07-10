class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> list = new ArrayList<>();
        
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        
        int n = words.length;
        
        for(String wrd: words) {
            int[] freq = new int[26];
            
            for(char ch: wrd.toCharArray()) {
                freq[ch - 97] ++;
            }
            
            for(int i=0; i<26; i++) {
                if(freq[i] < common[i])
                    common[i] = freq[i];
            }
        }
        
        for(int i=0; i<26; i++) {
            if(common[i] != 0) {
                int cnt = common[i];
                char ch = (char)(i + 97);
                
                while(cnt-- > 0)
                    list.add(String.valueOf(ch));
            }     
        }
        return list;
    }
}