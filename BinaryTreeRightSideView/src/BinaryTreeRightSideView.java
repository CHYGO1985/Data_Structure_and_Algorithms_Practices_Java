import java.util.LinkedList;
import java.util.List;


/**
 * 
 * 199. Binary Tree Right Side View
 * 
 * round 1: solved, 15m, use IDE to find ++ and + 1 difference
 * 
 * @author jingjiejiang
 */
public class BinaryTreeRightSideView {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new LinkedList<>();
        getNodes(root, list, 1);
        
        return list;
    }
    
    private void getNodes(TreeNode root, List<Integer> list, int level) {
        
        if (root == null) 
            return;
        
        if (level > list.size()) 
            list.add(root.val);
        
        getNodes(root.right, list, level + 1);
        getNodes(root.left, list,  level + 1);
    }
}
