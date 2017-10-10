import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Convert Binary Tree into Threaded Binary Tree
 * 
 * 1.method 1 (traditional) : inorder traverse to build a list, then iterate
 * through the list if the right node is null, then let it point to the next 
 * node.
 * 2.method 2: right first inroder traverse. visit right child first inorder
 * traverse. if right child == null and previous visit node is not null,
 * then let right point to the previous node.
 * 
 * NB: be careful about previous visited node.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 10, 2017
 */
public class ConvertBiTreeIntoThreadedBiTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
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
	
	// method 1: form an inorder list, then check the list for the node
	// whose right child is null
	/*
	public static void ConvertBiTreeIntoThreadedBiTree (TreeNode root) {
		
		List<TreeNode> list = new LinkedList<>();
		InorderTraverse(root, list);
		
		while (list.isEmpty() == false) {
			
			TreeNode cur = list.remove(0);
			
			if (cur.right == null && list.isEmpty() == false)
				cur.right = list.get(0);
		}
	}
	
	private static void InorderTraverse (TreeNode root, List<TreeNode> list) {
		
		if (root == null) return ;
		
		InorderTraverse(root.left, list);
		list.add(root);
		InorderTraverse(root.right, list);
	}
	*/
	
	// method 2: do not use extra space, rigth first inorder traverse + previous visted node
	public static void ConvertBiTreeIntoThreadedBiTree (TreeNode root, TreeNode preVisit) {
		
		if (root == null) return;
		
		ConvertBiTreeIntoThreadedBiTree(root.right, preVisit);
		
		if (root.right == null && preVisit != null) 
			root.right = preVisit;
		
		ConvertBiTreeIntoThreadedBiTree(root.left, root);
	} 
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,-1,-1,-1,-1,-1,-1,-1,-1};
		
		// build tree from array of data
		TreeNode root = new TreeNode(nums[0]);
		buildTreeFromArray(root, nums);
		
		ConvertBiTreeIntoThreadedBiTree(root, null);
		
	}

}
