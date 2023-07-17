//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        
        ArrayList<Integer> posi = new ArrayList<>();
        ArrayList<Integer> nega = new ArrayList<>();
        
        
        for(int i=0; i<n; i++) {
            if(arr[i] >= 0) posi.add(arr[i]);
            if(arr[i] < 0) nega.add(arr[i]);
        }
        
        if(posi.size() > nega.size()) {
            for(int i=0; i<nega.size(); i++) {
                arr[2*i] = posi.get(i);
                arr[2*i+1] = nega.get(i);
            }
            int idx = nega.size()*2;
            for(int j=nega.size(); j<posi.size(); j++)
                arr[idx++] = posi.get(j);
        } 
        else {
            for(int i=0; i<posi.size(); i++) {
                arr[2*i] = posi.get(i);
                arr[2*i+1] = nega.get(i);
            }
            int idx = posi.size()*2;
            for(int j=posi.size(); j<nega.size(); j++)
                arr[idx++] = nega.get(j);
        }
        //return res;
    }
}