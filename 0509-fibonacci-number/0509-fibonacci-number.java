class Solution {
    public int fib(int n) {
        
        if(n==0) return 0;
        if(n==1) return 1;

        // return fib(n-1) + fib(n-2);
        int n1=0, n2=1, n3=0;

        while(n>1){
            n3 = n1+n2;
            n1=n2;
            n2=n3;
            n--;
        }
        return n3;
    }
}