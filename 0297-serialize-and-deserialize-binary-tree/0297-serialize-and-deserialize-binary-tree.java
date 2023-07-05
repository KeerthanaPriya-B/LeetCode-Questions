/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //recording: 2nd june Binary tree 4 time(1:00:00)
	//my prediction - TC: O(N)  SC: O(N)
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
		preOrderTraversal(root, sb);
		
		return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        
        String[] preOrderArr = str.split(",");
		return Construct(preOrderArr);
    }
    
    int itr = 0;
	public TreeNode Construct(String[] preOrderArr) {
		
		if(itr >= preOrderArr.length || preOrderArr[itr].equals("null")) {
			itr++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(preOrderArr[itr]));
		itr++;
		
		root.left = Construct(preOrderArr);
		root.right = Construct(preOrderArr);
		return root;	
	}
	
	public void preOrderTraversal(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.val + ",");
		
		preOrderTraversal(root.left, sb);
		preOrderTraversal(root.right, sb);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));