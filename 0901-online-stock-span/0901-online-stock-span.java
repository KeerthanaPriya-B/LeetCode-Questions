class pair {
    int stock;
    int span;
    pair(int stock, int span){
        this.stock = stock;
        this.span = span;
    }
}
class StockSpanner {

    Stack<pair> s;
   
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        
        int cnt = 1;
        while(!s.isEmpty() && s.peek().stock <= price)
            cnt += s.pop().span;
        
        s.push(new pair(price, cnt));
        return cnt;   
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */