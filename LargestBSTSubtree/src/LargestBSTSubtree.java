
public class LargestBSTSubtree {
	
	// ref:https://discuss.leetcode.com/topic/36995/share-my-o-n-java-code-with-brief-explanation-and-comments
    // 1) divide each subtree from the root, compare root.val with left and right
    // 2) use the feature of BST that root.val > left.upper and root.val < right.lower
    
    // The problem of my method: 1) did not use root.val to compare, which makes the things very complicated
    // 2) coz I did not consider the use of root.val, I mixed the left and right, which violate the principle
    // of designning solutions for tree
	
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
	
	public static class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;
        
        public Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    static int max = 0;
    
    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        traverse(root);
        return max;
    }
    
    public static Result traverse(TreeNode root) {
        if (root == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
	
	/*
	public static class Indicator {
        
        boolean isValidForCur;
        boolean isValidForPar;
        int min;
        int max;
        int sum;
        
        public Indicator(boolean isValidForCur, boolean isValidForPar, int sum, int min, int max) {
            this.isValidForCur = isValidForCur;
            this.isValidForPar = isValidForPar;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    
    public static int largestBSTSubtree(TreeNode root) {
        // idea: recursive method
        // learned: 1. I was still not clear about the definition of BST, BST is the left subtree aleays less than ele 
        // in right subtree. Not work for only one small subtree, but work for the tree in a whole.
        // 2. when need to recurve different type of data, use a class to store
        // 3. in general. 1) think about from top to bottom or from bottom to top?
        // 2) what is the operation for each recursive step?
        
        if (null == root) {
            return 0;
        }
        
        Indicator indi = new Indicator(true, true, 1, root.val, root.val);
        indi = findLargestBSTSub(root, root, 0, indi);
        
        return indi.sum;
    }
    
    public static Indicator findLargestBSTSub(TreeNode parent, TreeNode root, int dir, Indicator indi) {
        
      // if root.left is null, return indi (0, true)
      if (null == root) {
          
          return new Indicator(true, true, 0, indi.min, indi.max);
      }
      
      boolean isValidForPar = true;
      indi.isValidForCur = true;
      indi.sum = 1;
      
      if(1 == dir) {
         
         if (indi.min != parent.val && root.val <= indi.min) {
             isValidForPar = false;
         }
         
         if (root.val >= parent.val) {
             indi.isValidForCur = false;
             isValidForPar = false;
             indi.max = root.val;
         }
         indi.min = root.val;
      }
      
      if (2 == dir) {
         
         if (indi.max != parent.val && root.val >= indi.max) {
             isValidForPar = false;
         }
         
         if (root.val <= parent.val) {
             indi.isValidForCur = false;
             isValidForPar = false;
             indi.min = root.val;
         }
         indi.max = root.val;
      }
      
      // compare with parent.val
      Indicator left = findLargestBSTSub(root, root.left, 1, indi);
      // compare with min / max
      indi.min = left.min;
      Indicator right = findLargestBSTSub(root, root.right, 2, indi);
      indi.max = right.max;
      
      int sum = 1;
      isValidForPar = left.isValidForPar & right.isValidForPar & isValidForPar;
      // if both are valid for cur tree 
      boolean isValidForCur = left.isValidForCur & right.isValidForCur & indi.isValidForCur;
      if (true == isValidForCur) {
          sum = left.sum + right.sum + 1;
          // if both are valid for parent tree
      }
      else {
    	  sum = Math.max(sum, Math.max(left.sum, right.sum));
      }
      
      // if it is a leaf, seperate isvalidforcur and isvalidforpar
      if ( null == root.left && null == root.right) {
    	  
    	 return new Indicator(isValidForCur, isValidForPar, sum, indi.min, indi.max);
      }
      
      return new Indicator(isValidForPar, isValidForPar, sum, indi.min, indi.max);
    }
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node22 = new TreeNode(2, null, null);
		TreeNode node8 = new TreeNode(8, node1, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node5 = new TreeNode(5, node22, node8);
		TreeNode node15 = new TreeNode(15, null, node7);
		TreeNode root = new TreeNode(10, node5, node15);
		
		// [1,3,null,null,4,2,null]
		/*
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node4 = new TreeNode(4, node2, null);
		TreeNode node3 = new TreeNode(3, null, node4);
		TreeNode root1 = new TreeNode(1, node3, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node3 = new TreeNode(3, node1, node4);
		TreeNode node5 = new TreeNode(5, node3, null);
		TreeNode root2 = new TreeNode(2, node5, null);
		*/
		
		int a = largestBSTSubtree(root);
	}

}
