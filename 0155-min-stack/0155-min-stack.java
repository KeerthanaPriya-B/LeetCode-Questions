class pair{
    int val, minele;
    pair(int val, int minele){
        this.val = val;
        this.minele = minele;
    }
}
class MinStack {

    Stack<pair> s;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int value) {
        
        if(s.isEmpty()) 
            min = value;
        else 
            min = Math.min(value, s.peek().minele);
        
        s.push(new pair(value, min));
    }
    
    public void pop() {
        
        s.pop();
    }
    
    public int top() {
        
        return s.peek().val;
    }
    
    public int getMin() {
        
        return s.peek().minele;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */