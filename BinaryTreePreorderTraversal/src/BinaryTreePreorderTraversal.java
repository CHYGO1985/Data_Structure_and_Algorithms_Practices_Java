import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
	
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x) { val = x; }
		}
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
	            
	            /*
	            if (false == isFstVisit) {
	                
	                while (topInStack.left != null) {
	                    
	                    topInStack = topInStack.left;
	                    list.add(topInStack.val);
	                    stack.push(topInStack);
	                }
	                topInStack = stack.pop();
	                isFstVisit = true;
	            }
	            else{
	                
	                topInStack = stack.pop();
	            }
	            */
	            
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
