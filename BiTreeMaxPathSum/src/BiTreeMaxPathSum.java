
public class BiTreeMaxPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    static int maxValue;
    
    public static int maxPathSum(TreeNode root) {
        
        maxValue = Integer.MIN_VALUE;
        calMaxNum(root);
        return maxValue;
    }
    
    private static int calMaxNum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        
        int left = Math.max(0, calMaxNum(root.left));
        int right = Math.max(0, calMaxNum(root.right));
        maxValue = Math.max(maxValue, right + left + root.val);
        return Math.max(left, right) + root.val;
    }   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node4;
		node3.right = node5;
		
		System.out.println(maxPathSum(root));
	}

}
