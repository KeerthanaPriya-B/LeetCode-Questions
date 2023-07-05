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
    public void flatten(TreeNode root) {
        
        //recording: 2nd june Binary tree 4 time(38:00:00)
		//TC: O(N^2) - inworst case, assume skew tree
		//(Construct func runs for Ntimes & while loop runs for Ntimes-so N^2)
		//SC: O(H)

		if(root == null)  return ;

		//flatten left subtree
		flatten(root.left);
		
		//flatten right subtree
		flatten(root.right);

		//rearrange flatten left subtree & right subtree
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;

		TreeNode curr = root;
		while(curr.right != null)
			curr = curr.right;

		curr.right = temp;
    }
}