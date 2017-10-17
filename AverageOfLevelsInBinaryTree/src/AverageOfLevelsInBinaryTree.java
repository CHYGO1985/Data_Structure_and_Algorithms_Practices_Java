import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * 637. Average of Levels in Binary Tree
 * 
 * round 1: solved. 25m
 * 
 * idea: obviously level order traverse
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 17, 2017
 *
 */
public class AverageOfLevelsInBinaryTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<Double> averageOfLevels(TreeNode root) {
        // recursive level order traverse
        Map<Integer, double[]> map = new TreeMap<>();
        
        int[] level = new int[]{0};
        getSumOfLevel(root, map, level);
        
        List<Double> list = new LinkedList<>();
        
        for (Integer key : map.keySet()) {
            double[] cur = map.get(key);
            list.add (cur[0] / cur[1]);
        }
        
        return list;
    }
    
    private void getSumOfLevel(TreeNode root, Map<Integer, double[]> map, int[] level) {
        
        if (root == null) return ;
        
        level[0] ++;
        if (map.containsKey(level[0]) == false) 
            map.put(level[0], new double[]{0.0, 0.0});
        
        double[] tmp = map.get(level[0]);
        tmp[0] += root.val;
        tmp[1] ++;
        
        if (root.right == null && root.left == null) {
            level[0] --;
            return;
        }
        
        getSumOfLevel(root.left, map, level);
        getSumOfLevel(root.right, map, level);
        
        level[0] --;
    }
}
