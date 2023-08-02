//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
        // code here
        int n = s.length();
        int[] charCount = new int[26];
        int maxCharCount = 0;
        int left = 0;
        int maxSubstringLength = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++;
            maxCharCount = Math.max(maxCharCount, charCount[currentChar - 'A']);

            if (right - left + 1 - maxCharCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
        }

        return maxSubstringLength;
    }
}
