import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 94. Binary Tree Inorder Traversal
 * 
 * round 2: 25m, more concise solution
 * idea: mimic recursive process
 * 1) fist find the leftmost node
 * 2) add the value of such node to list
 * 3) check right of the node, if it is not null, go to 1)
 * otherwise,go to 4)
 * 4) pop a node from stack, add its value to list, go to 3
 * 5) until find one's right child is not null, go to 1)
 * 
 * @author jingjiejiang
 * @history
 * 1. round 2 Oct 10, 2017
 */
public class BinaryTreeInorderTraversal {
	
	public static class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	// round 2 implementation
	public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null) return list;
        
        while (root != null) {
            
            // get left until left is null
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }

            // add current node value to list
            list.add(root.val);

            // check whether current node has right, if so add to stack
            // else pop a node from stack (1.add value to list
            // 2. check whether has right child 
            while (root.right == null && stack.empty() == false) {
                root = stack.pop();
                list.add(root.val);
            }
            
            root = root.right;
        }
        
        return list;
    }
	
	/*
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
	*/

}
