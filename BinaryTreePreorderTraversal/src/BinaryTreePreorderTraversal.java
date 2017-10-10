import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 144. Binary Tree Preorder Traversal
 * 
 * round 2: solved, 50m (much more concise than 1st version)
 * idea: mimic the recursive process (use stack to store intermediate status)
 * 
 * when design the loop, write the core steps first, then go for the loop
 * (from inside to outside)
 * 
 * @author jingjiejiang
 * @history
 * 1. round 2 Oct 10, 2017
 */
public class BinaryTreePreorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// round 2 implementation
	public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        // add every cur node's value to list
        
        while (root != null) {
            
            // add left to stack until null
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
        
            // pop every ele from the stack, add right to it
            TreeNode temp = stack.pop();
            while (temp.right == null && stack.empty() == false) {
                temp = stack.pop();
            }
            
            root = temp.right;
        }
        
        return list;
    }
	
	/*
	public static List<Integer> preorderTraversal(TreeNode root) {
        // * idea: use stack to represent the recursive procedure
        // * result : solved/half-solved/unsolved, used time and run time, % in the db, fastest in the db
        // * things learned：I was confused about preorder
        // *** result: 1ms, beat 31.62%, fastest is 0ms (4.48%)
        
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean isFstVisit = false;
        
        // special case
        if (root != null) {
            list.add(root.val);
            stack.push(root);
            if (null == root.left) {
                // *** i did not consider that left is empty
                isFstVisit = true;
            }
        }
        
        while (false == stack.empty()) {
            
            TreeNode topInStack = stack.peek();
            
            if (false == isFstVisit) {
                
                while (topInStack.left != null) {
                    
                    topInStack = topInStack.left;
                    list.add(topInStack.val);
                    stack.push(topInStack);
                }
                isFstVisit = true;
            }
                
            topInStack = stack.pop();
            
            if (topInStack.right != null) {
                list.add(topInStack.right.val);
                stack.push(topInStack.right);
                isFstVisit = false;
            }
        }
        
        return list;
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
