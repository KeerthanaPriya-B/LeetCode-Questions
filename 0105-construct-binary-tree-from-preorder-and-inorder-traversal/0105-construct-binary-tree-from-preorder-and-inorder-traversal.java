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
    
        //recording: 2nd june Binary tree 4 time(9:00:00)
        //TC: O(N^2) - inworst case, assume skew tree
        //(Construct func runs for Ntimes & while loop runs for Ntimes-so N^2)
        //SC: O(H)

    	public TreeNode Construct(int inorder[], int isi, int iei, int preorder[], int psi, int pei) {

        //isi-Inoreder Starting Index
		//iei-Inoreder Ending Index
		//psi-Preoreder Starting Index
		//pei-Preoreder Ending Index
            
		if(isi > iei || psi > pei)
			return null;

		TreeNode root = new TreeNode(preorder[psi]);
		int cntOfLST = 0;
		int i = isi;

		while(inorder[i] != root.val) {
			i++;
			cntOfLST++;
		}
		root.left = Construct(inorder, isi, i-1, preorder, psi+1, psi+cntOfLST);
		root.right = Construct(inorder, i+1, iei, preorder, psi+cntOfLST+1, pei);

		return root;
	}
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return Construct(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
}