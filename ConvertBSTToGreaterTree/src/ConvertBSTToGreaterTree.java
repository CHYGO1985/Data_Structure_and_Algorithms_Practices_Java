
/**
 * 
 * 538. Convert BST to Greater Tree
 * 
 * round 1: solved, 10m, reverse inorder
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 19, 2017
 */
public class ConvertBSTToGreaterTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode convertBST(TreeNode root) {
        
        int[] pre = new int[]{0};
        
        transformBST(root, pre);
        
        return root;
    }
    
    private void transformBST(TreeNode root, int[] pre) {
        
        if (root == null) return ;
        
        transformBST(root.right, pre);
        root.val += pre[0];
        pre[0] = root.val;
        transformBST(root.left, pre);
    }

}
