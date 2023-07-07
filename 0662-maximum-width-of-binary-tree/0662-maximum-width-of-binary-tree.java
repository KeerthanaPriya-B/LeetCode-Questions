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
    class Pair{
        TreeNode node;
        int ind;
        
        Pair(TreeNode node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        
        //watched Striver's video
        
        /*the idea is to have ind to every node where every new level should have index start from one.             To start the level with one, we need to subtract the level with minInd of that level before               creating newInd for next level nodes. Because, if any node is missing in the tree, then the               starting value of the ind in the level can be some other num other than one.*/
        
        if(root == null)  return 0;
		
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(root, 0));
        
		int maxWidth = 0, start = 0, end = 0;
        
        
		while(que.size() != 0) {
			int size = que.size();
            int minInd = que.peek().ind;
			
			for(int i=0; i<size; i++) {      
				Pair pair = que.remove();
                int currInd = pair.ind - minInd;
                
                if(pair.node.left != null)  
                    que.add(new Pair(pair.node.left,( 2*currInd) + 1));
                
                if(pair.node.right != null)  
                    que.add(new Pair(pair.node.right,( 2*currInd) + 2));
                
                if(i == 0)      start = pair.ind;
                if(i == size-1) end = pair.ind;			
			}
            
            int width = end - start + 1;
			maxWidth = Math.max(maxWidth, width);
		}
        
        return maxWidth;
    }
}