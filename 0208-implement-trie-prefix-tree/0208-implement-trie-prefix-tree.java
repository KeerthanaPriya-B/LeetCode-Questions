class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    boolean isPresent(char ch) {
        if(links[ch-'a'] != null)  return true;
        return false;
    }
    Node movenxt(char ch) {
        return links[ch-'a'];
    }
}
    
class Trie {
    
    //17th August recording
    
    Node root;
    public Trie() {
       root = new Node(); 
    }
    
    public void insert(String word) {
        int n = word.length();
        Node itr = root;
        
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if(! itr.isPresent(ch))  
                itr.links[ch-'a'] = new Node();  
            itr = itr.movenxt(ch);
        }
        itr.flag = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        Node itr = root;
        
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if(! itr.isPresent(ch)) 
                return false;
            itr = itr.movenxt(ch);
        }
        return itr.flag;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Node itr = root;
        
        for(int i=0; i<n; i++) {
            char ch = prefix.charAt(i);
            if(! itr.isPresent(ch)) 
                return false;
            itr = itr.movenxt(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */