//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        // code here
        HashMap<Integer, Integer> cumulativeSumDiff = new HashMap<>();

        int sum1 = 0, sum2 = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            // Convert boolean values to integers (true -> 1, false -> 0)
            int num1 = arr1[i] ? 1 : 0;
            int num2 = arr2[i] ? 1 : 0;

            // Calculate cumulative sums of both arrays
            sum1 += num1;
            sum2 += num2;

            // Calculate the difference between cumulative sums at the same index for both arrays
            int diff = sum1 - sum2;

            // If the difference is 0, it means that the sum of the subarray from index 0 to i is the same in both arrays
            if (diff == 0)
                maxLength = i + 1; // Update the maxLength to include the subarray from index 0 to i

            // If the difference is already present in the map, it means that the sum of the subarray between the two indices is the same in both arrays
            if (cumulativeSumDiff.containsKey(diff))
                maxLength = Math.max(maxLength, i - cumulativeSumDiff.get(diff));

            // If the difference is not present in the map, store it with its index
            if (!cumulativeSumDiff.containsKey(diff))
                cumulativeSumDiff.put(diff, i);
        }

        return maxLength;
    }
}