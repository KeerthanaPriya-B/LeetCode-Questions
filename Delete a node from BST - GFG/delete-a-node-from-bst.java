//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Tree g = new Tree();
            root = g.deleteNode(root, x);
            printInorder(root);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Tree {
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int val) {
        // code here.
        
        //lecture : 7th july BST 1 time(2:10:00)
		
		if(root == null)  return null;

		//finding the node that needs to be deleted
		if(val > root.data) {
			Node updatedRight = deleteNode(root.right, val);
			root.right = updatedRight;
		}
		else if(val < root.data) {
			Node updatedLeft = deleteNode(root.left, val);
			root.left = updatedLeft;
		}
		//found a node to be deleted
		else {
			//if a node is a leaf node
			if(root.left == null && root.right == null) {
				return null;
			}
			//if a node has only left child
			else if(root.left != null && root.right == null) {
				return root.left;
			}
			//if a node has only right child
			else if(root.left == null && root.right != null) {
				return root.right;
			}
			//if a node has both the children
			else {
				//node to be deleted needs to replaced with 
				//either max node from left subtree or 
				//min node from right subtree, then delete
				//the replaced node from its original position
				//to avoid duplicacy

				int minval = min(root.right);
				root.data = minval;
				root.right = deleteNode(root.right, minval);
			}
		}
		return root;
    }
	
	public static int min(Node root) {
		if(root.left == null)  return root.data;
		return min(root.left);
	}
}