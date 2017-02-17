
public class BiTreeMaxPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// idea: postorder + greedy (cal from bottom) 
    // 1) how to cal the leaf nodes
    
    // https://discuss.leetcode.com/topic/4407/accepted-short-solution-in-java/2
    // round 1: *** I did not consider the case of a negative number
    // *** 1) I misunderstand the concept of path (the most important mistake)
    //  [1,2,3,,4,5,4,5], the path is 5,2,1,3,5 not all will be included in the path
    // *** 2) I do not know how to hanlde negative numbers for root, left and right (this is vital)
    // The solution: left and right return 0, and use Math.max(left, right) + node.val
    // *** 3) I do not know how to handle leaf node
    // The solution: return 0 for null
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
