//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] bucket = new int[26];
            for (int j = i; j < s.length(); j++) {
                bucket[s.charAt(j) - 'a']++;
                sum += beauty(bucket);
            }
        }
        
        return sum;
    }
    
    public static int beauty(int[] bucket) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) continue;
            min = Math.min(min, bucket[i]);
            max = Math.max(max, bucket[i]);
        }
        return max - min;
    }
    
}
        
