
public class FindBottomLeftTreeValue {
	
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
	}
	
    public class Solution {
	    private int res = 0;
	    private int depth = 0;
	    
	    public int findBottomLeftValue(TreeNode root) {
	        
	        // round 2: implement method 1
	        
	        // idea: method 1: layer order traverse, return the first ele of the last row
	        // 1) from the start of each layer, record the first ele
	        
	        // method 2: pre-order traverse, record the fisrt element that reach a new depth number
	        // ref: https://discuss.leetcode.com/topic/78962/simple-java-solution-beats-100-0/2
	        findValueHelper(root, 1);
	        return res;
	    }
	    
	    private void findValueHelper(TreeNode root, int height) {
	        if (height > depth) {
	            depth = height;
	            res = root.val;
	        }
	        
	        if (root.left != null) {
	            findValueHelper(root.left, height + 1);
	        }
	        
	        if (root.right != null) {
	            findValueHelper(root.right, height + 1);
	        }
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
