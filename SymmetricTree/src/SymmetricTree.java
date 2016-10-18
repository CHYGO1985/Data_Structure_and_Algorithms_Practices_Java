
public class SymmetricTree {
	
	public class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        // * Idea: what is the character when a tree is symmetric?
        // 1) in terms of 3rd layer, 2nd.left.left = 2nd.right.right; 2nd.left.right = 2nd.right.left
        // it can be seems that they are pairs like ([]), use stack... (compare left (from r to l) with right (from l to r))
        // how to do it recursively??
        // left deque, right queque
        // 2nd root.left, root.right
        // 3rd root.left.left and root.left.right
        //       root.right.left and root.right.right
        //         compare
        // *** level traversal like problem ***
        /*
        if (null == root) {
            return true;
        }
        
        Deque<TreeNode> left = new LinkedList<>();
        Deque<TreeNode> right = new LinkedList<>();
        
        int size = nodeStack.size();
        
        nodeStack.push(root.left);
        nodeStack.peek()
        
        while ()
        */
        
        // Second time: draw a draft to oberseve the law, and it can be seen that for all the nodes
        // if symmetric, l.l == r.r && l.r == r.l
        // Method 1: recursive --> 
        // **** result: 1ms, beat 23.40%, fastest in the database is 0ms: 5.03%.
        /*
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }
        else if (null == root.left || null == root.right) {
            return false;
        }
        */
        
        // Method 2: optimise judgement in method 1 
        // https://discuss.leetcode.com/topic/28589/1ms-recursive-java-solution-easy-to-understand
        // *** result: 0-1ms.
        
        
        if (null == root) {
            return true;
        }
        
        return checkSymmetric (root.left, root.right);
    }
    
    public static boolean checkSymmetric (TreeNode lNode, TreeNode rNode) {
        
        /*
        if (null == lNode && null == rNode) {
            return true;
        }
        else if ( (null == lNode || null == rNode) && (lNode != rNode) ) {
            return false;
        }
        else if (lNode.val != rNode.val) {
            return false;
        }
        */
        
        if (null == lNode && null == rNode) {
            return true;
        }
        else if ( (null == lNode || null == rNode) || (lNode.val != rNode.val)) {
            return false;
        }
        
        // as soon as find a asymmetric part, stop the loop (save time)
        // method 1: I was trying to save some time, but i seems it didn't success
        if (false == checkSymmetric (lNode.left, rNode.right) ) {
            return false;
        }
        
        if (false == checkSymmetric (lNode.right, rNode.left)) {
            return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
