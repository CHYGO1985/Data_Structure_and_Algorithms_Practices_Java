/**
 * 
 * 255. Verify Preorder Sequence in Binary Search Tree
 * 
 * round 1: unsolved
 * 
 * ref: https://discuss.leetcode.com/category/322/verify-preorder-sequence-in-binary-search-tree
 * 
 * idea: i was stuck at the situation when the preorder array violate the rule of BST
 * *** the rule is that. 1) go through the array, find the first ele A > previous ele
 * 2). from start to A, find the one that is closet and smaller than A, make it
 * as the limit for the lowest (limit), if further find one < limit, then it is
 * not an array for BST
 * 3) iterate through rest the array, when meet one > previous one, than repeat 1), 2) 
 * else, only check whether current ele < limit
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 14, 2017
 */
public class VerifyPreorderSeqinBST {
	
	/*
	public boolean verifyPreorder(int[] preorder) {
        
        if (null == preorder || 0 == preorder.length)
            return true;
        
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        stack.push(preorder[0]);
        int index = 1;

        while (index < preorder.length) {
            // put first ele (root) into stack

            // if current < lowest limit, return false;
            if (preorder[index] < low) return false;

            // if < current ele, push put element into stack
//            if (preorder[index] < stack.peek())
//                stack.push(preorder[index]);
//            // while > current ele, pop from stack, update the lowest limti 
//            else {
//                while (stack.empty() == false && preorder[index] > stack.peek()) {
//                low = stack.pop();
//                }
//                stack.push(preorder[index ++]);
//            }
            
            // refactoring from previous code
            while (stack.empty() == false && preorder[index] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(preorder[index ++]);
        }
        
        return true;
    }
    */
	
	// without using stack (two pointers tech)
    public boolean verifyPreorder(int[] preorder) {
        
        if (null == preorder || 0 == preorder.length)
            return true;
        
        int checkIndex = 1;
        int preIndex = checkIndex - 1;
        int low = Integer.MIN_VALUE;
        
        while (checkIndex < preorder.length) {
            
            if (preorder[checkIndex] < low) return false;
            
            while (preIndex >= 0 && preorder[checkIndex] > preorder[preIndex])
                low = preorder[preIndex --];
            
            // *** must update the bar after low limit, as the future low limit should not less
            // then preorder[checkIndex]
            // 1 3 4 2, when 4 > 3, should update 3 to 4
            preorder[++ preIndex] = preorder[checkIndex];
            
            checkIndex ++;
        }
        
        return true;
    }

}
