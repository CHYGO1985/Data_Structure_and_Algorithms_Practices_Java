import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 501. Find Mode in Binary Search Tree
 * 
 * round 1: solved, 3 hrs,
 * 
 * idea: without using extra space, then use time to exchange for space 
 * --> so two round traverse, 1st round find max occurrence, 2nd round
 * find the one that appear as max occurrence, add to list.
 * 
 * traverse: for BST tree, always think about inorder first
 * *** I used 3 hrs, because i used postorder at the beginning, 
 * 
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 28, 2017
 */
public class FindModeInBST {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public int[] findMode(TreeNode root) {
        
        // max[0] : the max val; max[1] : the current num; max[2] : the current count
        if (root == null) return new int[0];
        int[] max = new int[]{0, -1, -1, -1};
        
        List<Integer> list = new LinkedList<>();
        getModes(root, max, list);
        max[3] = max[0];
        list.clear();
        
        max[0] = 0;
        max[1] = max[2] = -1;
        getModes(root, max, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i ++)
            res[i] = list.get(i);
        
        return res;
    }
    
    private void getModes(TreeNode root, int[] max, List<Integer> list) {
        
        if (root == null) return;
        
        getModes(root.left, max, list);
        
        if (root.val == max[1]) {
            max[2] ++;
            
        }
        else {
            max[1] = root.val;
            max[2] = 1;
        }
        
        // *** need to update the data every round
        max[0] = Math.max(max[0], max[2]);
        if (max[2] == max[3]) list.add(max[1]);
        
        getModes(root.right, max, list);
    }
}
