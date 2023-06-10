class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        
        //TC: push-O(1)  pop & top most of the time takes TC: O(1) and such cases called amortized complexity but it is O(N) anyhow.
        s1.push(x);
        
        //commented lines of program has TC: push-O(N) & pop-O(1)
        // while(!s1.isEmpty()) s2.push(s1.pop());        
        // s1.push(x);       
        // while(!s2.isEmpty()) s1.push(s2.pop());
        
    }
    
    public int pop() {
        
        if(!s2.isEmpty()) return s2.pop();
        
        while(!s1.isEmpty())
            s2.push(s1.pop());
        
        return s2.pop();
        
        //return s1.pop();
    }
    
    public int peek() {
        
        if(!s2.isEmpty()) return s2.peek();
        
        while(!s1.isEmpty())
            s2.push(s1.pop());
        
        return s2.peek();
        
        //return s1.peek();
    }
    
    public boolean empty() {
        
        return s1.isEmpty() && s2.isEmpty();
        
       // return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */