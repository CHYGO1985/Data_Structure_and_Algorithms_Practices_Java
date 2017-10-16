
/**
 * 
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * round 1: solved, 15m, 1 attemps
 * idea: balanced BST, so we need to root at the mid of the sorted array
 * so we can divide the array evenly to build balanced BST.
 * root.val = nums[(start + end) / 2]
 * Also, it can be easily tell that
 * root.left can get from (start, mid - 1)
 * root.right can get from (mid + 1, end)
 * So, there goes the recursive method.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 16, 2017
 */
public class ConvertSortedArrayToBST {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}	

	public TreeNode sortedArrayToBST(int[] nums) {
        // recursive
        
        if (null == nums) return null;
        
        return buildBST(0, nums.length - 1, nums);
    }
    
    private TreeNode buildBST(int start, int end, int[] nums) {
        
        if (start > end) return null;
        
        // creat root, val as nums[(start + end) / 2]
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        // go for root.left, range (start, mid - 1)
        root.left = buildBST(start, mid - 1, nums);
        
        // go for root.right, range (mid + 1, end)
        root.right = buildBST(mid + 1, end, nums);
        
        return root;
    }
}
