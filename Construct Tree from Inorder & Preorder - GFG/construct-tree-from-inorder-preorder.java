//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    //recording: 2nd june Binary tree 4 time(9:00:00)
    
	//TC: O(N^2) - inworst case, assume skew tree
	//(Construct func runs for Ntimes & while loop runs for Ntimes-so N^2)
	//SC: O(H)
	
	
    public static Node buildTree(int inorder[], int preorder[], int n){
        //Your code here 

		return Construct(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
		
		//isi-Inoreder Starting Index
		//iei-Inoreder Ending Index
		//psi-Preoreder Starting Index
		//pei-Preoreder Ending Index
    }

	public static Node Construct(int inorder[], int isi, int iei, int preorder[], int psi, int pei) {

		if(isi > iei || psi > pei) 
			return null;

		Node root = new Node(preorder[psi]);
		int sizeOfLST = 0;
		int ind = isi;

		while(inorder[ind] != root.data) {
			ind++;
			sizeOfLST++;
		}
		
		root.left = Construct(inorder, isi, ind-1, preorder, psi+1, psi+sizeOfLST);
		root.right = Construct(inorder, ind+1, iei, preorder, psi+sizeOfLST+1, pei);

		return root;
	}
}
