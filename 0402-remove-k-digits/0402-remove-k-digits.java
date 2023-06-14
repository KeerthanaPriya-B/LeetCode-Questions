class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<num.length(); i++){
            char n = num.charAt(i);
            
            while(!s.isEmpty() && k>0 && s.peek()>n) {
                s.pop();
                k--;
            }
            if(s.isEmpty() && n=='0')
                continue;
            else
                s.push(n);
        }
        
        
        while(!s.isEmpty() && k>0){
            s.pop();
            k--;   
        }
        if(s.isEmpty()) return "0";
        
        StringBuilder sb = new StringBuilder();
         while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        
        return sb.toString();
        
    }
}