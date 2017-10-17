
/**
 * 
 * 129. Sum Root to Leaf Numbers
 * 
 * round 1: solved, 10m, 1 attemps
 * 
 * idea:
 * get two conditions: 
 * 1) only end when meets leaf
 * 2) use stringbuilder to keep intermediate path
 * so it is a similar method as only act (similar to Path Sum II )
 * 
 * Java :*** StringBuilder deleteCharAt(int index) method and delete(int start, int end) method
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 17, 2017
 */
public class SumRootToLeafNumbers {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
        
        int[] sum = new int[]{0};
        getSum(root, new StringBuilder(), sum);
        
        return sum[0];
    }
    
    private void getSum(TreeNode root, StringBuilder builder, int[] sum) {
        
        if (root == null) return ;
        
        builder.append(root.val);
        
        if (root.left == null && root.right == null) {
            sum[0] += Integer.valueOf(builder.toString());
            builder.deleteCharAt(builder.length() - 1);
            return ;
        }
        
        getSum(root.left, builder, sum);
        getSum(root.right, builder, sum);
        // remove the previous visted node
        builder.deleteCharAt(builder.length() - 1);
        
    }
}
