package Tree;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 653. Two Sum IV - Input is a BST
 * 
 * round 1: solved, 1.5 hr (should think about an sorted array for BST)
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 19. 2017 
 * 2. Feb 4, 2019
 */
public class TwoSumIV {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}	

//	public boolean findTarget(TreeNode root, int k) {
//        
//        if (root == null) return false;
//
//        Set<Integer> set = new HashSet<>();
//        boolean[] res = new boolean[]{false};
//        
//        checkMatch(root, k, set, res);
//        
//        return res[0];
//    }
//    
//    private void checkMatch(TreeNode root, int k, Set<Integer> set, boolean[] res) {
//        
//        if (root == null)
//            return ;
//
//        checkMatch(root.left, k, set, res);
//        
//        if (set.contains(k - root.val))
//            res[0] = true;
//        
//        set.add(root.val);
//        
//        checkMatch(root.right, k, set, res);
//        
//    }

	public boolean findTarget(TreeNode root, int k) {
		
		Set<Integer> valSet = new HashSet<>();
        return finder(root, valSet, k);
    }
	
	public boolean finder(TreeNode root, Set<Integer> valSet, int k) {
		
		if (root == null) return false;
		
		if (valSet.contains(k - root.val)) {
			return true;
		}
		valSet.add(root.val);
		
		return finder(root.left, valSet, k) || finder(root.right, valSet, k);
	}
}
