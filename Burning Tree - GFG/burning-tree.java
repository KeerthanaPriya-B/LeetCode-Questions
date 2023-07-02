//{ Driver Code Starts
//Initial Template for Java


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
			if (i >= ip.length)
				break;

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
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        //recording: 30th june Binary search 3 time(2:53:00)
        //TC: O(N)  SC: O(N) 
        
        
        //finding burning node
        Node src = find(root, target);
        
        //if there is no burning node
        if(src == null)
            return 0;  
            
        //stores child -> parent
        HashMap<Node, Node> map = new HashMap<>();
        mapping(root, map);
        
        //stores burnt nodes, to avoid burning it again
        HashSet<Node> vis = new HashSet<>();
        vis.add(src);
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(src);
        
        int level = 0;
        while(que.size() != 0) {
            int size = que.size();
            
            while(size--> 0) {
                Node node = que.remove();
                
                //burning left child
                if(node.left != null && vis.contains(node.left) == false) {
                    que.add(node.left);
                    vis.add(node.left);
                }
                //burning right child
                if(node.right != null && vis.contains(node.right) == false) {
                    que.add(node.right);
                    vis.add(node.right);
                }
                //burning parent 
                if(map.containsKey(node) && vis.contains(map.get(node)) == false) {
                    que.add(map.get(node));
                    vis.add(map.get(node));
                }
            }
            level++;
        }
        
        if(level == 0)
            return 0;
            
        //minimum time
        return level-1;
    }
    
    public static void mapping(Node root, HashMap<Node, Node> map) {
        if(root == null)  return;
        
        if(root.left != null)
            map.put(root.left, root);
            
        if(root.right != null)
            map.put(root.right, root);
            
        mapping(root.left, map);
        mapping(root.right, map);
    }
    
    public static Node find(Node root, int target) {
        if(root == null)  return null;
        
        if(root.data == target)  return root;
        
        Node leftChild = find(root.left, target);
        if(leftChild != null)  
            return leftChild;
            
        Node rightChild = find(root.right, target);
        if(rightChild != null)  
            return rightChild;
        
        return null;
    }
}