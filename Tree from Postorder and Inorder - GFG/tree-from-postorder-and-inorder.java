//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //recording: 2nd june Binary tree 4 time(9:00:00)
	//TC: O(N^2) - inworst case, assume skew tree
	//(Construct func runs for Ntimes & while loop runs for Ntimes-so N^2)
	//SC: O(H)
	
	//isi-Inoreder Starting Index
	//iei-Inoreder Ending Index
	//psi-Preoreder Starting Index
	//pei-Preoreder Ending Index
	
    Node construct(int in[], int isi, int iei, int post[], int psi, int pei) {
		if(isi > iei || psi > pei)
			return null;

		Node root = new Node(post[pei]);
		int ind = isi;
		int sizeOfLST = 0;

		while(in[ind] != root.data) {
			ind++;
			sizeOfLST++;
		}
		root.left = construct(in, isi, ind-1, post, psi, psi+sizeOfLST-1);
		root.right = construct(in, ind+1, iei, post, psi+sizeOfLST, pei-1);
		return root;
	}
	
	//Function to return a tree created from postorder and inoreder traversals.
	
    Node buildTree(int in[], int post[], int n){
        //Write code here
		return construct(in, 0, in.length-1, post, 0, post.length-1);
    }
}
