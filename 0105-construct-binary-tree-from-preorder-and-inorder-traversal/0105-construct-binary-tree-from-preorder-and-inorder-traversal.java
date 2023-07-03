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
    	public TreeNode Construct(int inorder[], int isi, int iei, int preorder[], int psi, int pei) {

		if(isi > iei || psi > pei)
			return null;

		TreeNode root = new TreeNode(preorder[psi]);
		int cntOfLST = 0;
		int i = isi;

		while(inorder[i] != root.val) {
			i++;
			cntOfLST++;
		}
		//System.out.println(i+" "+cntOfLST);
		root.left = Construct(inorder, isi, i-1, preorder, psi+1, psi+cntOfLST);
		root.right = Construct(inorder, i+1, iei, preorder, psi+cntOfLST+1, pei);

		return root;
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Construct(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
}