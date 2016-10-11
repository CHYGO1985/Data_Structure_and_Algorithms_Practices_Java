
public class BalancedBinaryTree {
	
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	
	public static boolean isBalanced(TreeNode root) {
        // * idea: from HFS algorithm --> judge height
        // *** problem: I was not familiar with height search algorithm
        
        // *** method 1: recursive, return value method (lots of if)
        // 2 ms, beat 22.5%, fastest 1ms
        // *** method 2: optimised recursive method.https://discuss.leetcode.com/topic/37096/java-1ms-solution
        
        int dif = hBalanChecker(root, 0);
        
        if (-1 == dif) {
            return false;
        }
        
        return true;
    }
    
    /*
    // method 1
    public int hBalanChecker (TreeNode root) {
        
         if (null == root) {
            return 0;
        }
        
        if (null == root.left && null == root.right) {
            return 1;
        }
        
        int lHeight = hBalanChecker(root.left);
        int rHeight = hBalanChecker(root.right);
        
        // for recursive method, it is not possible to keep -1 in the middle of the execution, so need to keep the temp result
        // I choose to use -1.
        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }
        else if (-1 == lHeight || -1 == rHeight) {
            return -1;
        } 
        else {
            return lHeight > rHeight ? lHeight + 1: rHeight + 1;
        }
    }
    */
    
    // method 2: exchagne space for time
    // optimised recursive method: https://discuss.leetcode.com/topic/37096/java-1ms-solution
    public static int hBalanChecker (TreeNode root, int height) {
        
          if (root == null)
            {
                return height;
            }
            
            int leftTree = hBalanChecker(root.left, height + 1);
            int rightTree = hBalanChecker(root.right, height + 1);
            if (leftTree < 0 || rightTree < 0 || Math.abs(leftTree - rightTree) > 1)
            {
                return -1;
            }
            
            return Math.max(leftTree, rightTree);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
