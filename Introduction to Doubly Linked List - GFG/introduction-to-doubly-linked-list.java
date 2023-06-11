//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev= null;
    }

} 
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
            }
            
            Solution obj = new Solution();
            Node ans = obj.constructDLL(arr);
            while(ans!=null){
                System.out.print(ans.data+" ");
                ans=ans.next;
            }
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        
        Node head=null;
        Node prev=null;
        Node next=null;
        Node tail=null;
        
        for(int ele: arr){
            Node newnode = new Node(ele);
            
            if(head==null){
                head = newnode;
                tail = newnode;
            } else{
                newnode.prev = tail;
                tail.next = newnode;
                tail = newnode;
            }
        }
        return head;
    }
}