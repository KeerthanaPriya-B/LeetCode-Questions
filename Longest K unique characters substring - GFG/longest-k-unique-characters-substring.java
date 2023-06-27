//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        //recording: 26th june Hashing 4 time(2:40:00)
		//TC: O(N)  SC: O(26)~O(1)

		//in hashmap if the key is Character i.e alphabets,
		//SC: O(26) which is approxi O(1)
		HashMap<Character, Integer> fmap = new HashMap<>();

		int inc = -1;
		int exc = -1;
		int maxLen = -1;
		int n = s.length();

		while(true) {
			boolean f1 = false;
			boolean f2 = false;

			//inc
			if(inc+1 < n && fmap.size() <= k) {
				inc++;
				char ch = s.charAt(inc);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

				//this is a valid window of k unique char
				if(fmap.size() == k) {
					int len = inc - exc;
					maxLen = Math.max(maxLen, len);
				}
				f1 = true;
			}
			//exc
			else if(exc < inc && fmap.size() > k) {
				exc++;
				char ch = s.charAt(exc);
				fmap.put(ch, fmap.get(ch) - 1);

				//removing char if it becomes zero, as it will act as a unique char
				if(fmap.get(ch) == 0)
					fmap.remove(ch);

				f2 = true;
			}

			//when inc & exc both the operation didn't happen, 
			//we can end the loop
			if(f1 == false && f2 == false)
				break;
		}
		return maxLen;
    }
    
}