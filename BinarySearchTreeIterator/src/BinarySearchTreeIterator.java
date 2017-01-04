import java.util.Stack;


public class BinarySearchTreeIterator {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	}
	
	private Stack<TreeNode> nodes;

    public BinarySearchTreeIterator(TreeNode root) {
        
        nodes = new Stack<TreeNode>();
        pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        if (true == nodes.empty()) {
            return false;
        }
        else {
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode cur = nodes.pop();
        pushAllLeft(cur.right);
        
        return cur.val;
    }
    
    private void pushAllLeft(TreeNode root) {
        
        for(; root != null; root = root.left) {
            nodes.push(root);
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
