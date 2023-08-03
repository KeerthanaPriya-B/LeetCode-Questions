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
class BSTiterator {
    private Stack<TreeNode> s;
    private boolean leftToright;
    
    public BSTiterator(TreeNode root, boolean leftToright) {
        s = new Stack<>();
        this.leftToright = leftToright;
        pushNodes(root);
    }
    public int next() {
        TreeNode node = s.pop();
        TreeNode childnode  = (leftToright) ? node.right : node.left;
        pushNodes(childnode);
        return node.val;
    }
    public void pushNodes(TreeNode node) {
        while(node != null) {
            s.push(node);
            node = (leftToright) ? node.left : node.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTiterator fromstart = new BSTiterator(root, true);
        BSTiterator fromend = new BSTiterator(root, false);
        
        int i = fromstart.next();
        int j = fromend.next();
        
        while(i < j) {
            if(i+j == k) return true;
            
            if(i+j < k) i = fromstart.next();
            else  j = fromend.next();
        }
        return false;
    }
}