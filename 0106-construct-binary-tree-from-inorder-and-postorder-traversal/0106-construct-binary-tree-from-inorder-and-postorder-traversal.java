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
    public TreeNode buildTree(int[] in, int[] post) {
        return construct(in, 0, in.length-1, post, 0, post.length-1);
    }
    
    public TreeNode construct(int in[], int isi, int iei, int post[], int psi, int pei) {
		if(isi > iei || psi > pei)
			return null;

		TreeNode root = new TreeNode(post[pei]);
		int ind = isi;
		int sizeOfLST = 0;

		while(in[ind] != root.val) {
			ind++;
			sizeOfLST++;
		}
		root.left = construct(in, isi, ind-1, post, psi, psi+sizeOfLST-1);
		root.right = construct(in, ind+1, iei, post, psi+sizeOfLST, pei-1);
		return root;
	}
	
}