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
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> al = new ArrayList<>();
        
        if(root == null)  return al;
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        
        while(que.size() != 0) {
            int size = que.size();
            int rightMostele = 0;
            
            while(size--> 0) {
                TreeNode node = que.remove();
                rightMostele = node.val;
                
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
            }
            al.add(rightMostele);
        }
        return al;
    }
}