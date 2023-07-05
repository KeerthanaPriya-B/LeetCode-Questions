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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        	    //recording: 29th june binary search 2 time(2:37:00)
		//TC: O(N)  SC: O(2^H) atmax we can have all the nodes 
		//of one level in queue(full binary tree)
		
		List<List<Integer>> res = new ArrayList<>();
		
        if(root == null)
            return res;
        
		Queue<TreeNode> que = new ArrayDeque<>();
		que.add(root);
		int level = 0;
		
		while(que.size() != 0) {
			List<Integer> al = new ArrayList<>();
			int size = que.size();
	
			while(size-- > 0) {
				TreeNode node = que.remove();
				al.add(node.val);
				
				if(node.left != null)
					que.add(node.left);
				
				if(node.right != null)
					que.add(node.right);
			}
			
			if(level%2 == 0) {
				//for(int i=0; i<al.size(); i++)
					res.add(al);
			} else {
				//for(int i=al.size()-1; i>=0; i--)
                Collections.reverse(al);
					res.add(al);
			}
			level++;
		}
		return res;
    }
}