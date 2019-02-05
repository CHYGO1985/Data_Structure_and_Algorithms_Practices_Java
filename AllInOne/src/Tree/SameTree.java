package Tree;

/**
 * 
 * @author jingjiejiang Feb 5 ,2019
 *
 */
public class SameTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) return true;
        
        if ((p == null && q != null) || (p != null && q == null)
           || p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
