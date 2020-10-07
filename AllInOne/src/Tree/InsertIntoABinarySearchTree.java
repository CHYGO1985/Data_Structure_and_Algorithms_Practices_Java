/**
 * 
 * 701. Insert into a Binary Search Tree
 * 
 * @CHYGO1985
 * @history Oct 7, 2020
 * 
 */
class Solution {
    //     public TreeNode insertIntoBST(TreeNode root, int val) {
            
    //         if (root == null) return new TreeNode(val);
            
    //         TreeNode dummy = new TreeNode(0, root, null);
    //         root = helper(root, val);
            
    //         return dummy.left;
    //     }
        
    //     private void helper(TreeNode root, int val) {
            
    //         if (root == null) {
    //             return; 
    //         } 
            
    //         if (val < root.val) {
    //             if (root.left == null) {
    //                 root.left = new TreeNode(val);
    //                 return ;
    //             }
                    
    //             insertIntoBST(root.left, val);
    //         } else {
                
    //             if (root.right == null) {
    //                 root.right = new TreeNode(val);
    //                 return ;
    //             }
                
    //             insertIntoBST(root.right, val);
    //         }
    //     }
        
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        root = helper(root, val);
        return root;
    }
    
    private TreeNode helper(TreeNode root, int val) {
        
        if (root == null) {
            return new TreeNode(val);
        } 
        
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
}
