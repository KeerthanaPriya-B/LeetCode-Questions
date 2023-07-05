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
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
        
//     }
       //recording: 30th june Binary search 3 time(12:00:00)
	//TC: O()  SC: O()
	
	int LeftMost_VLevel = 0;
	int RightMost_VLevel = 0;

	void traversal(TreeNode root, int pos) {
		if(root == null) 
			return;

		LeftMost_VLevel = Math.min(LeftMost_VLevel, pos);
		RightMost_VLevel = Math.max(RightMost_VLevel, pos);
		
		traversal(root.left, pos-1);
		traversal(root.right, pos+1);
	}

	class Pair implements Comparable<Pair>{
		TreeNode node;
		int Vlevel;
		Pair(TreeNode node, int Vlevel) {
			this.node = node;
			this.Vlevel = Vlevel;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.Vlevel == o.Vlevel)
				return this.node.val - o.node.val;
			else
				return this.Vlevel - o.Vlevel;
		}
	}
    List<List<Integer>> verticalTraversal(TreeNode root) {
        //Write your code here

		traversal(root, 0);
		int NoOfVlevel = RightMost_VLevel - LeftMost_VLevel + 1;
		int VlevelOfRoot = -LeftMost_VLevel;

		List<List<Integer>> res = new ArrayList<>();
		for(int i=0; i<NoOfVlevel; i++) 
			res.add(new ArrayList<>());
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(root, VlevelOfRoot));

		while(pq.size() != 0) {
			int size = pq.size();
			PriorityQueue<Pair> Childpq = new PriorityQueue<>();
			
			while(size--> 0) {
				Pair pair = pq.remove();
				
				List<Integer> list = res.get(pair.Vlevel);
				list.add(pair.node.val);

				if(pair.node.left != null)
					Childpq.add(new Pair(pair.node.left, pair.Vlevel-1));

				if(pair.node.right != null)
					Childpq.add(new Pair(pair.node.right, pair.Vlevel+1));
			}
			pq = Childpq;
		}
		return res;
    }
}