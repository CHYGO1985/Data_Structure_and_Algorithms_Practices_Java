/**
 * 
 * 450. Delete Node in a BST
 * 
 * round 1: unsolved
 * 
 * problem: 1. **** use return treenode method to change the structure, then do
 * not need to record parent node
 * 2. two methods of delete node, one is rotation: another is get the min of
 * the right subtree of the deleting node A assign the value to the root B 
 * (mathch key), then delete that A
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 21, 2017
 */
public class DeleteNodeInABST {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public String tree2str(TreeNode t) {
        
        StringBuilder builder = new StringBuilder();
        
        if (t == null)
            return "";
        
        builder.append(t.val);
        getString(t.left, builder);
        getString(t.right, builder);
        
        return builder.toString();
    }
    
    private void getString(TreeNode root, StringBuilder builder) {
        
        if (root == null) return ;
        
        builder.append("(").append(root.val);
        
        getString(root.left, builder);
        getString(root.right, builder);
        
        if (root.left == null && root.right != null) {
            builder.insert(builder.length() - 2, ")");
        }
        
        builder.append(")");
    }

}
