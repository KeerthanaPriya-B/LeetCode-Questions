class Solution {
    class Pair{
        String wrd;
        int steps;
        Pair(String wrd, int steps) {
            this.wrd = wrd;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord, 1));
        
        HashSet<String> set = new HashSet<>();
        for(String w: wordList)  set.add(w);
        
        set.remove(beginWord);
        
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            
            for(int i=0; i<pair.wrd.length(); i++) {
                for(char c='a'; c<='z'; c++) {
                    char[] ch = pair.wrd.toCharArray();
                    ch[i] = c;
                    String newStr = new String(ch);
                    
                    if(set.contains(newStr)) {
                        if(newStr.equals(endWord)) {
                            return pair.steps + 1;
                        }
                        set.remove(newStr);
                        q.add(new Pair(newStr, pair.steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}