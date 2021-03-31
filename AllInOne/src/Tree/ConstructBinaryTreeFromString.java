/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * 
 * 536. Construct Binary Tree from String
 * 
 * @author jingjiejiang
 * @history Mar 16, 2021
 * 
 * ref: 536. Construct Binary Tree from String
 * 
 */
class ConstructBinaryTreeFromString {

    public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

    public TreeNode str2tree(String s) {
        
        if (s == null || s.length() == 0) return null;

        int fstParIdx = s.indexOf("(");
        int fstNum = (fstParIdx == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, fstParIdx)));
        TreeNode curNode = new TreeNode(fstNum);

        if (fstParIdx == -1) return curNode;

        int start = fstParIdx, parPairCnt = 0;

        for (int idx = start; idx < s.length(); idx ++) {

            if (s.charAt(idx) == '(') parPairCnt ++;
            else if (s.charAt(idx) == ')') parPairCnt --;

            if (parPairCnt == 0 && start == fstParIdx) {

                curNode.left = str2tree(s.substring(start + 1, idx));
                start = idx + 1;
            } else if (parPairCnt == 0) {
                // here start + 1. because it must begin with (X...
                curNode.right = str2tree(s.substring(start + 1, idx));
            }
        }

        return curNode;
    }
}