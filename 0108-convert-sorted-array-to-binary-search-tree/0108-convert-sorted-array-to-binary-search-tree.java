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
    public TreeNode construct(int[] nums, int l, int h) {
        
        if(l > h) return null;
        int mid = (l+h)/2;
        
        TreeNode newTree = new TreeNode(nums[mid]);
        newTree.left = construct(nums, l, mid-1);
        newTree.right = construct(nums, mid+1, h);
        
        return newTree;  
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
}