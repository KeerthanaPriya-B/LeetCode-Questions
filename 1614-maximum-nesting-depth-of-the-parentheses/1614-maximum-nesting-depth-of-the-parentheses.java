class Solution {
    public int maxDepth(String s) {
        
        int cnt = 0, depth = 0;
        
        for(char c: s.toCharArray()) {
            if(c == '(') {
                cnt++;
                depth = Math.max(depth, cnt);
            }
            else if(c == ')'){
                cnt--;
            }
        }
        
        return depth;
    }
}