
public class SumOfLeftLeaves {
	
	public class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	public static int sumOfLeftLeaves(TreeNode root) {
        // difficult part: how to distinguish whether it is a left leaf or not.
        // * idea: recursive (use boolean to check whether it is left leaf)
        // *** result: 9 ms, beat 44.63%, fastest: 7ms.
        
        // method 2: optimisation of my method
        // http://www.itdadao.com/articles/c15a510240p0.html
        /*
        if (!root) return 0;
        if (root->left && !root->left->left && !root->left->right) {
            return root->left->val + sumOfLeftLeaves(root->right);
        }
        return sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
        */
        
        // method 3:http://www.itdadao.com/articles/c15a510240p0.html
        // level order travese.
        /*
         if (!root || (!root->left && !root->right)) return 0;
        int res = 0;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            TreeNode *t = q.front(); q.pop();
            if (t->left && !t->left->left && !t->left->right) res += t->left->val;
            if (t->left) q.push(t->left);
            if (t->right) q.push(t->right);
        }
        return res;
        */
        
        if (null == root || (null == root.left && null == root.right)) {
            return 0;
        }
        
        int sum = 0;
        sum = leftLeaveCount(root.left, true);
        sum += leftLeaveCount(root.right, false);
        
        return sum;
    }
    
    public static int leftLeaveCount (TreeNode root, boolean isLeft) {
        
        // if left leaf return 1, if right leaf return 0
        // Be careful about the case that when root is null.
        if (null == root) {
            return 0;
        }
        else if (null == root.left && null == root.right) {
            
            if (true == isLeft) {
                return root.val;
            }
            else {
                return 0;
            }
        }
        
        int sum = leftLeaveCount(root.left, true);
        sum += leftLeaveCount(root.right, false);
        
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
