
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinked {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x, TreeNode left, TreeNode right) {
			val = x;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode (int x) {
			this.val = x;
		}
    }
	
	// round 2: method, from left to right, without extra space
    public void flatten(TreeNode root) {
        
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if (null == root) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (null != left) {
            //*** node to hanlde right==null || != null seperately
            if (null != right) {
            	TreeNode temp = left;
            	while (temp.right != null) {
            		temp = temp.right;
            	}
            	temp.right = right;
            }
            
        	root.right = left;
        	root.left = null;
        }
        
        return root;
    }
	
	// * method 2: post order
    // ref: https://discuss.leetcode.com/topic/11444/my-short-post-order-traversal-java-solution-for-share
	// runtime: 1ms
	/*
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */
    /*
    // method 1: preorder + linkedlist
    public void flatten(TreeNode root) {
        
        if (null == root) {
            return ;
        }
        
        List<Integer> list = new LinkedList<Integer>();
        buildTree(root, list);
        
        int i = 0;
        for (; i < list.size() - 1; i ++) {
            root.val = list.get(i);
            root.left = null;
            root.right = new TreeNode(0);
            root = root.right;
        }
        
        root.val = list.get(i);
    }
    
    public void buildTree(TreeNode root, List<Integer> list) {
        
        if (null == root) {
            return ;
        }
        
        list.add(root.val);
        
        buildTree(root.left, list);
        buildTree(root.right, list);
    }
    */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* test case:
		[]
		[1]
		[3,1,2]
		[10, 5, 15, 1,8,null,7]
		[1,3,null,null,4,2,null]
		[10,8,null,7,null,6,null,5]
		[10,null,8,null,7,null,6,null,5]
		*/
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node3 = new TreeNode(3);
		TreeNode root = new TreeNode(1,node2,node3);
	}

}
