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
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int LHeight = findHeight(root.left);
        int RHeight = findHeight(root.right);
        
        maxi = Math.max(maxi, LHeight + RHeight);
        
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return maxi;
    }
    public int findHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}