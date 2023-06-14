class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        long M = 1000000007;
        Stack<Integer> s = new Stack<>();
        long ans = 0;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                
                if(!s.isEmpty())  lb = s.peek();
                
                long noOfSubarr = (idx - lb) * (rb - idx);
                long sum = ((noOfSubarr % M) * (arr[idx] % M)) % M;
                ans = (ans + sum) % M;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            long noOfSubarr = (idx - lb) * (rb - idx);
            long sum = ((noOfSubarr % M) * (arr[idx] % M)) % M;
            ans = (ans + sum) % M;
        }
        return (int)ans;
        
    }
}