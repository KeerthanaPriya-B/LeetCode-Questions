class Solution {
    public long subArrayRanges(int[] arr) {
        
       // long M = 1000000007;
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
                long sum = noOfSubarr * arr[idx];
                ans = ans - sum;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            long noOfSubarr = (idx - lb) * (rb - idx);
            long sum = noOfSubarr * arr[idx];
            ans = ans - sum;
        }
        
        s.clear();
        //  long M = 1000000007;
        // Stack<Integer> s = new Stack<>();
        // long ans = 0;
        // int n = arr.length;
        
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]){
                int rb = i;
                int lb = -1;
                int idx = s.pop();
                
                if(!s.isEmpty())  lb = s.peek();
                
                long noOfSubarr = (idx - lb) * (rb - idx);
                long sum = noOfSubarr * arr[idx];
                ans = ans + sum;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int rb = n;
            int lb = -1;
            int idx = s.pop();

            if(!s.isEmpty())  lb = s.peek();

            long noOfSubarr = (idx - lb) * (rb - idx);
            long sum = noOfSubarr * arr[idx];
            ans = ans + sum;
    }
        //return (int)ans;
        return ans;
    }
}