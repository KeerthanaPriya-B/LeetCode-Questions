/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        
        //lecture : 7th july BST 1 time(2:10:00)
		
		if(root == null)  return null;

		//finding the node that needs to be deleted
		if(val > root.val) {
			TreeNode updatedRight = deleteNode(root.right, val);
			root.right = updatedRight;
		}
		else if(val < root.val) {
			TreeNode updatedLeft = deleteNode(root.left, val);
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

				int maxval = max(root.left);
				root.val = maxval;
				root.left = deleteNode(root.left, maxval);
			}
		}
		return root;
    }
	
	public int max(TreeNode root) {
		if(root.right == null)  return root.val;
		return max(root.right);
	}

}