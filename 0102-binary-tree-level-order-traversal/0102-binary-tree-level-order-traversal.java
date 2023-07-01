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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //recording: 29th june binary search 2 time(1:33:00)
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Queue<TreeNode> que = new ArrayDeque<>();
        
        que.add(root);
        while(que.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int size = que.size();
            
            while(size--> 0) {
                TreeNode node = que.remove();
                list.add(node.val);
                
                if(node.left != null)
                    que.add(node.left);
                
                if(node.right != null)
                    que.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}