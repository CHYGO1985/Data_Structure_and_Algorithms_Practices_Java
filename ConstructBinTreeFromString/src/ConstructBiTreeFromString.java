/**
 * 
 * 536. Construct Binary Tree from String
 * 
 * ref idea: e.g. : 1(2(4)(5))(1)
 * 
 * // ref: https://discuss.leetcode.com/topic/82572/java-recursive-solution/2
 * 
 * whole idea: recursive deal with left and right, first divide left and right (3)
 * 1(2(4)(5))(1) --> left:  (2(4)(5)), right : (3)
 * then do it recursively.
 * (2(4)(5)) --> left : (4) , right: (5)
 * 
 * ***1. how to tell left or right?
 * use leftParenCount to count the number of pairs of parenthesis and a 'start' for
 * counting the start position
 * if  leftParenCount == 0, means now there is a new subtree.
 * 
 * left: start = firstParen, else right.
 * we update start after creating the left tree, so when it coms the time to create
 * right. it will != firstParan
 * 
 * @author jingjiejiang
 * @history
 * 1. OCt 21, 2017
 */
public class ConstructBiTreeFromString {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static TreeNode str2tree(String s) {
        
if (s == null || s.length() == 0) return null;
        
        int firstParen = s.indexOf("(");
        
        // -1 --> for case: the s only has numbers "1232", i.e. only root
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if (firstParen == -1) return cur;
        
        // *** leftParent is to record 
        int start = firstParen, leftParenCount = 0;
        
        for (int i = start; i < s.length(); i ++) {
            if (s.charAt(i) == '(') { 
                leftParenCount ++;
            }
            else if (s.charAt(i) == ')') {
                leftParenCount --;
            }
            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(s.substring(start + 1, i)); 
                // *** start is used to identify the range of left and right, update start
                // then next time leftParenCount == 0, we will create right tree
                start = i + 1;
            }
            else if (leftParenCount == 0) 
                cur.right = str2tree(s.substring(start + 1,i));
        }
        return cur;
    }
	
	public static void main(String[] args) {
		TreeNode root = str2tree("1(2(4)(5))(1)");
		// TreeNode root = str2tree("4(2(34)(1))(6(5))");
	}
}
