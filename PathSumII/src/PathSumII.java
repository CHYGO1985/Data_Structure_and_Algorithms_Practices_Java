import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 113. Path Sum II
 * 
 * round 1: solved, 30m, 3 attemps
 * 
 * idea: 1) return list of list, to i need a tmp list to store current path
 * 2) from root to leaf, so only add tmp list to final list at leaf
 * 3) only add the copy of the tmp list, coz actively changing tmp list will
 * affect the final list
 * 4) postorder to remove visited node
 * 
 * 1) test case: *** i did not know that [1, 2] 1, count as [], not [[1]]
 * 2) ***programming: actively storing a temp list
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 17, 2017
 */
public class PathSumII {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tmpList = new LinkedList<>();
            
        getPath(list, tmpList, root, sum);
        
        return list;
    }
    
    private void getPath(List<List<Integer>> list, List<Integer> tmpList, TreeNode root, int sum) {
        
        if (root == null) return; 
        
        sum -= root.val;
        tmpList.add(root.val);
        
        if (sum == 0 && root.left == null && root.right == null) {
            list.add(new LinkedList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return ;
        }
        getPath(list, tmpList, root.left, sum);
        getPath(list, tmpList, root.right, sum);
        
        // post order to remove visited node
        tmpList.remove(tmpList.size() - 1);
    }
}
