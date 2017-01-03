
public class InorderSuccessorInBST {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x, TreeNode left, TreeNode right) {
			val = x;
			this.left = left;
			this.right = right;
		}
	}

	
	// idea: method 1: inorder travese, use a boolean flag
    // result: 5ms, beat 22%, majority on 4ms
    // my solution is generalised to binary tree, not only for BST
    
    // method 2: use the feature of BST
    // ref: https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution
    /*
    public TreeNode successor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;
    
      if (root.val <= p.val) {
        return successor(root.right, p);
      } else {
        TreeNode left = successor(root.left, p);
        return (left != null) ? left : root;
      }
    }
    */
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
     
        if (null == root) {
            return null;
        } 
        
        TreeNode res = findInorderSuccessor(root, false, p);
        
        if (res == p) {
            return null;
        }
        return res;
    }
    
    public TreeNode findInorderSuccessor(TreeNode root, boolean isSuccessor, TreeNode p) {
        
        if (null == root) {
            if (true == isSuccessor) {
                return p;
            }
            return null; 
        }
        else {
            // *** must need a null == root.left condition, coz if it has left, then obviously it is not the successor
            if (true == isSuccessor && null == root.left) {
                return root;
            }
        }
        
        TreeNode left = findInorderSuccessor(root.left, isSuccessor, p);
        
        if (left != null ) {
            if (left == p) {
                left = root;
            }
            
            // *** notice to set flag == false, when left != p (which means it has the successor)
            // otherwise, the right part will replace it
            isSuccessor = false;
        }
        
        if (root == p) {
            isSuccessor = true;
        }
            
        TreeNode right = findInorderSuccessor(root.right, isSuccessor, p);
        
        return right == null? left : right;
        // used to replace
        /*
        if (right == null) {
            return left;
        }
        else {
            return right;
        }
        */
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
