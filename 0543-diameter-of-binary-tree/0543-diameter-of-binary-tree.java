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
//     public int diameterOfBinaryTree(TreeNode root) {
        
//     }
    
    static class Pair {
		int dia;
		int height;
		Pair(int dia, int height) {
			this.dia = dia;
			this.height = height;
		}
	}
	public static int diameterOfBinaryTree(TreeNode root) {
		//write your code here
		Pair ans = diameter2(root);
		return ans.dia - 1;	
	}
	
	public static Pair diameter2(TreeNode root) {
		if(root == null) 
			return new Pair(0, 0);

		Pair LST = diameter2(root.left);
		Pair RST = diameter2(root.right);
		int diaOfRoot = LST.height + 1 + RST.height;

		int diaOfTree = Math.max(diaOfRoot, Math.max(LST.dia, RST.dia));
		int heightOfTree = Math.max(LST.height, RST.height) + 1;
		
		return new Pair(diaOfTree, heightOfTree);
	}
}