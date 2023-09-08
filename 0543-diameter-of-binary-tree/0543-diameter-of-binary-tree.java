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
//     int maxi = 0;
     public int diameterOfBinaryTree(TreeNode root) {
    
            int[] maxi = new int[1];
            findHeight(root, maxi);
            return maxi[0];
//         if(root == null) return 0;
        
//         int LHeight = findHeight(root.left);
//         int RHeight = findHeight(root.right);
        
//         maxi = Math.max(maxi, LHeight + RHeight);
        
//         diameterOfBinaryTree(root.left);
//         diameterOfBinaryTree(root.right);
        
//         return maxi;
     }
    public int findHeight(TreeNode root, int[] maxi) {
        if(root == null) return 0;
        
        int LST = findHeight(root.left, maxi);
        int RST = findHeight(root.right, maxi);
        
        maxi[0] = Math.max(maxi[0], LST + RST);
        return 1 + Math.max(LST, RST);
    }
}