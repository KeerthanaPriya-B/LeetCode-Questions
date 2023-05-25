class Solution {
    public int numberOfSteps(int num) {
        
        return helper(num, 0);
    }
    
    static int helper(int num, int cnt){
        
        if(num == 0) return cnt;
        if(num%2==0) return helper(num/2, cnt+1);
        return helper(num-1, cnt+1);
    }
}
