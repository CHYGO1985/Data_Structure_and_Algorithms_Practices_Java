
public class KthSmallestEletInBST {
	
	 public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
        TreeNode(int x) { val = x; }
     }
	
	 public int kthSmallest(TreeNode root, int k) {
        // Round 1: **** used 1 hour, did not get the O(log(n)) solution
		// *** things learned: can only count the num of nodes as half
		 
        // Idea: i thought about building a list (in-order), then search the kth in the list, O(n)
        // 1. I was thinking to use bianry search, but stuck on get the whole nodes count of the tree --> can count only half
        // The method only count half nodes of the tree
        // https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-python-binary-search-in-order-iterative-recursive
        
        if (null == root) 
            return -1;
        int nodes = count(root.left);
        if (k <= nodes) {
            return kthSmallest(root.left, k);
        }
        else if (k > nodes + 1) {
            // *** I missed -1, 1 represent the root
            return kthSmallest(root.right, k - nodes - 1);
        }
        
        return root.val;
    }
    
    public int count(TreeNode root) {
        if (null == root)
            return 0; 
        return 1 + count(root.left) + count(root.right);
    }
}
