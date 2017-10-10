import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 * Convert BST to Greater Sum Tree
 * Objec­tive: Given a binary search tree (BST), con­vert it into greater sum tree.
 * What is greater sum tree: Greater sum tree is a tree in which every node 
 * con­tains the sum of all the nodes which are greater than the node.
 * 
 * round 1: solved, 30 minutes
 * 
 * idea: find the bigger ele, cannot do inorder traverse from left, should do
 * from right. so we can only get bigger vals than the rest part. 
 * 
 * The process of designing recursive method:
 * right down each step first, then try to merge them into one.
 * 
 * ref: http://algorithms.tutorialhorizon.com/convert-bst-to-greater-sum-tree/
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 10, 2017
 */
public class ConvertBSTToGreaterSumTree {
	
	public static class TreeNode {
		
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void buildTreeFromArray(TreeNode root, int[] nums) {
		
		if (null == nums || 0 == nums.length) return ;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		int index = 1;
		
		while (index < nums.length - 1 && queue.isEmpty() == false) {
			
			TreeNode tmp = queue.poll();
			
			if (nums[index] != -1) {
				tmp.left = new TreeNode(nums[index]);
				queue.add(tmp.left);
			}
			index ++;
			
			if (nums[index] != -1) {
				tmp.right = new TreeNode(nums[index]);
				queue.add(tmp.right);
			}
			index ++;
		}
	}
	
	public static int getGreatSumTree(TreeNode root, int sum) {
		
		if (root == null) return sum;
		
		sum = getGreatSumTree(root.right, sum);
		int tmp = root.val;
		root.val = sum;
		sum += tmp;
		return getGreatSumTree(root.left, sum);
	}
	
	public static void main(String[] args) {
		
		int[] nums = {10,5,15,2,7,12,20,-1,-1,-1,-1,-1,-1,-1,-1};
		
		// build tree from array of data
		TreeNode root = new TreeNode(nums[0]);
		buildTreeFromArray(root, nums);
		getGreatSumTree(root, 0);
	}
}
