class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> st = new Stack<>();
        int cnt = 0, depth = 0;
        
        for(char c: s.toCharArray()) {
            if(c == '(') {
                st.push(c);
                cnt++;
                depth = Math.max(depth, cnt);
            }
            else if(c == ')'){
                cnt--;
                while(!st.isEmpty() && st.pop() != '(')
                    continue;
            }
            // else
            //     st.push(c);
        }
        
        return depth;
    }
}