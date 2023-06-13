class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> s = new Stack<>();
        
        for(int ele: asteroids){
            if(ele>0)
                s.push(ele);
            else{
                //stack.peek()-positive case
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(ele))
                    s.pop();
                
                //stack.peek()-empty & negative case
                if(s.isEmpty() || s.peek()<0)
                    s.push(ele);
                
                //stack.peek()-equal case
                else if(!s.isEmpty() && s.peek()==Math.abs(ele))
                    s.pop();
            }
        }
        
        int[] res = new int[s.size()];
        
        for(int i=s.size()-1; i>=0; i--)
            res[i] = s.pop();
        
        return res;
    }
}