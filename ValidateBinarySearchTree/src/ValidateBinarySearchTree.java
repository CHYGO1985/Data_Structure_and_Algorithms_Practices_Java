
public class ValidateBinarySearchTree {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x, TreeNode left, TreeNode right) { 
			 val = x;
			 this.left = left;
			 this.right = right;
	     }
   }
	
	// general idea: root > min (left), root < max (right)
	// for every subtree, min must be left or root, max must be right or root
	
	/*// version 1: post-order, bottom-up, with max and min store in a seperate class
    public class Result {
        
        boolean isValid;
        int min;
        int max;
        
        public Result (boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        // Method 1 : bottom-up method: 333. Largest BST Subtree
        
        if (null == root) {
            return true;
        }
        // Method 2: bottom up, keep up dating min and max
        Result res = checkBST(root);
        
        return res.isValid;
    }
    
    // indiMin is for the whole left subtree
    public Result checkBST(TreeNode root) {
        
        if (null == root) {
            return null;
        }

        // traverse left
        Result left = checkBST(root.left);
        // traverse right
        Result right = checkBST(root.right);
        
        // if it is a leaf node
        if (null == left && null == right) {
            return new Result(true, root.val, root.val);
        }
        
        int max = 0;
        int min = 0;
        
        // compare with parent node 
        // 1) previous left or right is false, then return false
        // 2) left.max < root, else false
        // 3) right.min > root, else false
        if ( (null != left && (left.max >= root.val || false == left.isValid) )
             || (null != right && (right.min <= root.val || false == right.isValid) ) ) {
            return new Result(false, 0, 0);
        }
        
        // replace min with left.min, otherwise use root
        if (left != null) {
            min = left.min;
        }
        else {
            min = root.val;
        }
        
        // replace max with right.max,otherwise use root
        if (right != null) {
            max = right.max;
        }
        else {
            max = root.val;
        }
        
        return new Result (true, min, max);
    }
	
	*/
	// Method 2: pre-order, top-down
	public boolean isValidBST(TreeNode root) {
        // Method 1 : post-order, bottom-up, need to use a sperate class to store max and min, runtime 2ms
        
        // Method 2: pre-order,top-down, do not need to store max and min, runtime 1ms
        // https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
        
        if (null == root) {
            return true;
        }
        // Method 2: bottom up, keep up dating min and max
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // indiMin is for the whole left subtree
    public boolean  checkBST(TreeNode root, long min, long max) {
        
        if (null == root) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        // traverse left
        boolean left = checkBST(root.left, min, root.val);
        // traverse right
        boolean right = checkBST(root.right, root.val, max);
        
        return left & right;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test case:
		/* []
			[1]
			[2,1,3]
			[10, 5, 15, 1,8,null,7,null,null,1]
			[1,3,null,null,4,2,null]
			[10,8,null,7,null,6,null,5,null,5]
			[10,8,null,8]
			[2147483647]
			[-2147483648,null,2147483647]
			[5, 14,null, 1]
			[3,1,5,0,2,4,6,null,null,null,3]
			[3,1,5,0,2,4,6]

		 * 
		 */
	}

}
