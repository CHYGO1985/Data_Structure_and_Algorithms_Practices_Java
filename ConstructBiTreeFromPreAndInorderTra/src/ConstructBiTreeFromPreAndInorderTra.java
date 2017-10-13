
/**
 * 
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * round 1: unsolved, 30m
 * ref: https://discuss.leetcode.com/topic/3695/my-accepted-java-solution
 * 
 * idea:1) oberserving what can be decide from preorder and inorder ? --> root
 * 2) decide a recursive process for it
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 13, 2017
 */
public class ConstructBiTreeFromPreAndInorderTra {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (null == preorder || 0 == preorder.length || null == inorder || 0 == inorder.length)
            return null;
        
        return builder(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode builder(int preIndex, int startInIndex, int endInIndex, 
                             int[] preorder, int[] inorder) {
        // ***
        if (endInIndex < 0 || startInIndex > endInIndex || preIndex >= preorder.length) return null;
            
        // the fst ele in preorder is the root
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        // find the index of cur root in inorder
        int matchIndex = 0;
        for (int i = startInIndex; i <= endInIndex; i ++) {
            if (inorder[i] == preorder[preIndex]) {
                matchIndex = i;
                break;
            }
        }
        
        // *** preorder should start from preIndex + 1
        root.left = builder(preIndex + 1, startInIndex, matchIndex - 1, preorder, inorder);
        root.right = builder(preIndex + matchIndex - startInIndex + 1, matchIndex + 1, endInIndex,
                            preorder, inorder);
        return root;
        
    } 
}
