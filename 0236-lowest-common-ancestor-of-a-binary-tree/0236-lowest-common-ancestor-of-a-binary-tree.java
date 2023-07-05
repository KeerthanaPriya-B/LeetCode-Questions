/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode n1, TreeNode n2) {
        
        //recording: 30th june Binary search 3 time(2:30:00)
		
		if(node == null)  return null;

		if(node.val == n1.val || node.val == n2.val)
			return node;

		TreeNode leftChild = lowestCommonAncestor(node.left, n1, n2);
		TreeNode rightChild = lowestCommonAncestor(node.right, n1, n2);

		if(leftChild != null && rightChild != null)
			return node;
		else if(leftChild != null)
			return leftChild;
		else if(rightChild != null)
			return rightChild;
		else
			return null;
    }
}