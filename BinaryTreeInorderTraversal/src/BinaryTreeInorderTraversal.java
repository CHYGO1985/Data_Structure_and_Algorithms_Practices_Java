import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	
	public static class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        // * idea: recursive --> stack, iterative --> explicitly use stack to implement the recursive inorder
        // * result : solved, 60 minutes, 1ms, beat 36.83% in the db, fastest in the db is 1ms, 3.3%
        // * things learned: spacial case
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        
        // *** spcial case: root == null
        if (root != null) {
            stack.push(root);
        }
        
        // to control when a Treenode is pop, whether to revisit the left node.
        boolean isLeftVisited = false;
        
        while (false == stack.empty()) {
            
            TreeNode temp = stack.peek(); 
            // put left part into the stack first
            while (temp.left != null && false == isLeftVisited) {
                
                stack.push(temp.left);
                temp = temp.left;
            }
            
            // if all left has been stored, out put val of root/parent node
            TreeNode cur = stack.pop();
            list.add(cur.val);
            isLeftVisited = true;
            
            // repeat with right node of root node
            if (cur.right != null) {
                stack.push(cur.right);
                isLeftVisited = false;
            }
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
