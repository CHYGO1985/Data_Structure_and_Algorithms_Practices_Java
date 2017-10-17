import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 257. Binary Tree Paths
 * 
 * round 1: round 1: solved, 20m
 * idea: 1) act when meet leaf node,  
 * 2) save intermediate node
 * --> use method of 113. Path Sum II 
 * 
 * @author jingjiejiang
 * @history
 * 1.Oct 17. 2017
 */
public class BinaryTreePaths {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new LinkedList<String>();
        getPaths(root, list, new StringBuilder());
        return list;       
    }
    
    private void getPaths(TreeNode root, List<String> list, StringBuilder builder) {
        
        // for the actual root of the tree
        if (root == null) return ;
        
        builder.append(root.val).append("->");
        
        // to prevent duplication when meets leaf node, so check here
        if (root.left == null && root.right == null) {
            // remove "->" at the tail
            int length = builder.length();
            builder.delete(length - 2, length);
            list.add(builder.toString());
            return ;
        }
        
        getPaths(root.left, list, new StringBuilder(builder));
        getPaths(root.right, list, new StringBuilder(builder));
        
    }
}
