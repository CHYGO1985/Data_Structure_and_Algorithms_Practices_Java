import java.util.LinkedList;
import java.util.List;


public class ZigzagLevelOrder {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
		 // method 1: linked list (for treenode and integer) + layer order traverse + layer%2 flag (flag for whether 
        // insert to offset 0) 
        // or use layer%2 flag to save one space
        
        List<List<Integer>> list = new LinkedList<List<Integer>>(); 
        if (null == root) {
            return list;
        }
        
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        int layer = 0;
        
        while (nodeList.size() != 0) {
            
            int nodeSum = nodeList.size();
            List<Integer> cur = new LinkedList<Integer>();
            while (nodeSum > 0) {
                
                // get every node from nodelist from the beginning
                TreeNode temp = nodeList.get(0);
                nodeList.remove(0);
                // add left and right of node to node list
                if (temp.left != null) {
                    nodeList.add(temp.left);
                }
                if (temp.right != null) {
                    nodeList.add(temp.right);
                }
                
                // add curent node val to val list
                // if (layer%2 != 0), add to offset 0
                if (0 == layer % 2) {
                    cur.add(temp.val);
                }
                else {
                    cur.add(0, temp.val);
                }
                
                // nodeSum --
                nodeSum--;
            }
            
            // add list to res list
            list.add(cur);
            //layer ++
            layer ++;
        }
        
        // return
        return list;
        
        
        // method 2: linklied list + preorder traverse + layer%2 flag
        // pre/in/post order can still get the layer info, i have figure it out myself in previous application
        // https://discuss.leetcode.com/topic/3413/my-accepted-java-solution   
        // result : 2ms, one of 49.39%, beat 42.46%
        /*
        List<List<Integer>> list = new LinkedList<List<Integer>>(); 
        if (null == root) {
            return list;
        }
        
        zigzagTraverse(root, list, 0);
        
        return list;
        */
    }
    
    // method 2:
    public void zigzagTraverse(TreeNode root, List<List<Integer>> list, int layer) {
        
        if (null == root) {
            return ;
        }
        
        // if list.size <= layer, add a new layer
        // = is to prevent out of index when layer = size = 0
        if (list.size() <= layer) {
        
            List<Integer> temp = new LinkedList<Integer>();
            list.add(temp);
        }
        
        // if not, get the sublist at layer, add the root.val to it
        List<Integer> cur = list.get(layer);
        if (0 == layer % 2) {
            cur.add(root.val);
        }
        else {
            cur.add(0, root.val);
        }
        
        // go to left
        zigzagTraverse(root.left, list, layer + 1);
        // go to right
        zigzagTraverse(root.right, list, layer + 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
